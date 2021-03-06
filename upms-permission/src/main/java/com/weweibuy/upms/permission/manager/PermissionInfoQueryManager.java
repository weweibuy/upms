package com.weweibuy.upms.permission.manager;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.upms.interfaces.user.IUserService;
import com.weweibuy.upms.interfaces.user.model.IUserGroup;
import com.weweibuy.upms.permission.model.eum.UserSymbolTypeEum;
import com.weweibuy.upms.permission.model.po.*;
import com.weweibuy.upms.permission.repository.ApiDataPermissionRepository;
import com.weweibuy.upms.permission.repository.ApiRepository;
import com.weweibuy.upms.permission.repository.FunctionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 权限信息查询
 *
 * @author durenhao
 * @date 2021/1/24 21:31
 **/
@Component
@RequiredArgsConstructor
public class PermissionInfoQueryManager {

    private final FunctionRepository functionRepository;

    private final ApiRepository apiRepository;

    private final IUserService iUserService;

    private final ApiDataPermissionRepository apiDataPermissionRepository;


    /**
     * 查询已有权限的api
     *
     * @param userName
     * @return
     */
    public List<Api> queryAuthorizedApi(String userName) {
        List<IUserGroup> userGroupList = iUserService.queryUserGroup(userName);
        List<String> groupCodeList = userGroupList.stream()
                .map(IUserGroup::getGroupCode)
                .collect(Collectors.toList());

        List<FunctionPermission> functionPermissionList1 = functionRepository.selectFunctionPermission(groupCodeList, UserSymbolTypeEum.GROUP);

        List<FunctionPermission> functionPermissionList2 = functionRepository.selectFunctionPermission(userName, UserSymbolTypeEum.USER);
        List<String> functionCodeList = Stream.concat(functionPermissionList1.stream(), functionPermissionList2.stream())
                .map(FunctionPermission::getFunctionCode)
                .distinct()
                .collect(Collectors.toList());

        List<Function> functionList = queryFunctionWithChild(functionCodeList);

        List<String> apiFunctionCodeList = functionList.stream()
                .map(Function::getFunctionCode)
                .distinct()
                .collect(Collectors.toList());
        return queryApiByFunctionCode(apiFunctionCodeList);
    }


    /**
     * @param functionCodeList
     * @return
     */
    public void queryChildFunction(List<Function> container, List<String> functionCodeList) {
        List<Function> childFunctionList = functionRepository.selectChildFunction(functionCodeList);
        if (CollectionUtils.isNotEmpty(childFunctionList)) {
            container.addAll(childFunctionList);
            queryChildFunction(container, childFunctionList.stream()
                    .map(Function::getFunctionCode)
                    .collect(Collectors.toList()));
        }
    }


    public List<Function> queryFunctionWithChild(List<String> functionCodeList) {
        List<Function> resultFunctionList = new ArrayList<>();
        List<Function> functionList = functionRepository.selectFunction(functionCodeList);
        if (CollectionUtils.isEmpty(functionList)) {
            return Collections.emptyList();
        }
        while (true) {
            resultFunctionList.addAll(functionList);
            functionList = functionRepository.selectChildFunction(functionList.stream()
                    .map(Function::getFunctionCode)
                    .collect(Collectors.toList()));
            if (CollectionUtils.isEmpty(functionList)) {
                break;
            }
        }
        return resultFunctionList;
    }


    /**
     * 查询功能下的 api
     *
     * @param functionCodeList
     * @return
     */
    public List<Api> queryApiByFunctionCode(List<String> functionCodeList) {
        List<FunctionApiRelation> functionApiRelationList = apiRepository.selectFunctionApiRelation(functionCodeList);
        List<String> apiCodeList = functionApiRelationList.stream()
                .map(FunctionApiRelation::getApiCode)
                .collect(Collectors.toList());

        return apiRepository.selectApi(apiCodeList);
    }


    public List<ApiDataPermissionField> queryApiDataPermissionField(String service, String path, HttpMethod httpMethod) {
        Api api = apiRepository.selectApi(service, path, httpMethod)
                .orElseThrow(() -> Exceptions.formatBusiness("不存在的Api: 服务:%s, 路径:%s, 方法:%s", service, path, httpMethod));

        return apiDataPermissionRepository.selectField(api.getApiCode());

    }


    public List<ApiDataPermission> queryUserApiDataPermission(List<String> dataCodeList, String username) {

        List<IUserGroup> userGroup = iUserService.queryUserGroup(username);

        List<ApiDataPermission> dataPermissionList1 = Collections.emptyList();
        if (CollectionUtils.isNotEmpty(userGroup)) {
            List<String> groupCodeList = userGroup.stream()
                    .map(IUserGroup::getGroupCode)
                    .collect(Collectors.toList());
            dataPermissionList1 = apiDataPermissionRepository.selectDataPermission(dataCodeList, groupCodeList, UserSymbolTypeEum.GROUP);
        }

        List<ApiDataPermission> dataPermissionList2 = apiDataPermissionRepository.selectDataPermission(dataCodeList, username, UserSymbolTypeEum.USER);

        if (CollectionUtils.isEmpty(dataPermissionList1) && CollectionUtils.isEmpty(dataPermissionList2)) {
            return Collections.emptyList();
        }
        return Stream.concat(dataPermissionList1.stream(), dataPermissionList2.stream())
                .distinct()
                .collect(Collectors.toList());
    }

}
