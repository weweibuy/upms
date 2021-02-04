package com.weweibuy.upms.permission.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.upms.permission.manager.PermissionInfoQueryManager;
import com.weweibuy.upms.permission.manager.TokenManager;
import com.weweibuy.upms.permission.model.dto.req.DataPermissionReqDTO;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReqDTO;
import com.weweibuy.upms.permission.model.dto.resp.DataPermissionRespDTO;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationRespDTO;
import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.model.po.ApiDataPermission;
import com.weweibuy.upms.permission.model.po.ApiDataPermissionField;
import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 鉴权服务
 *
 * @author durenhao
 * @date 2021/1/24 20:59
 **/
@Service
@RequiredArgsConstructor
public class UserAuthorizationService {

    private final TokenManager tokenManager;

    private final PermissionInfoQueryManager permissionInfoQueryManager;


    public CommonDataResponse<UserAuthorizationRespDTO> authorization(UserAuthorizationReqDTO req) {
        TokenUserInfo tokenUserInfo = null;
        try {
            tokenUserInfo = tokenManager.tokenToUserInfo(req.getAuthorization());
        } catch (Exception e) {
            return CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null);
        }

        String username = tokenUserInfo.getUsername();

        List<Api> apiList = permissionInfoQueryManager.queryAuthorizedApi(username);
        return apiList.stream()
                .filter(a -> a.getApiService().equals(req.getService()))
                .filter(a -> a.getApiAddress().equals(req.getPath()))
                .filter(a -> a.getApiMethod().equals(req.getHttpMethod().toString()))
                .findFirst()
                .map(a -> CommonDataResponse.success(UserAuthorizationRespDTO.fromUsername(username)))
                .orElseGet(() -> CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, UserAuthorizationRespDTO.fromUsername(username)));


    }

    public CommonDataResponse<List<DataPermissionRespDTO>> dataAuthorization(DataPermissionReqDTO dataPermissionReq) {
        List<ApiDataPermissionField> permissionFieldList = permissionInfoQueryManager.queryApiDataPermissionField(
                dataPermissionReq.getService(), dataPermissionReq.getPath(), dataPermissionReq.getHttpMethod());
        if (CollectionUtils.isEmpty(permissionFieldList)) {
            // 不做控制
            return CommonDataResponse.success(Collections.emptyList());
        }
        List<String> dataCodeList = new ArrayList<>();

        Map<String, ApiDataPermissionField> dataCodeFieldMap = permissionFieldList.stream()
                .peek(a -> dataCodeList.add(a.getDataCode()))
                .collect(Collectors.toMap(ApiDataPermissionField::getDataCode, Function.identity(), (o, n) -> n));

        List<ApiDataPermission> dataPermission = permissionInfoQueryManager.queryUserApiDataPermission(dataCodeList, dataPermissionReq.getUsername());
        // 数据权限乐观 控制
        if (CollectionUtils.isEmpty(dataPermission)) {
            return CommonDataResponse.success(Collections.emptyList());
        }
        List<DataPermissionRespDTO> permissionRespDTOList = dataPermission.stream()
                .map(dp -> dataPermission(dp, dataCodeFieldMap.get(dp.getDataCode())))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return CommonDataResponse.success(permissionRespDTOList);
    }


    private DataPermissionRespDTO dataPermission(ApiDataPermission dataPermission, ApiDataPermissionField dataPermissionField) {
        if (dataPermissionField == null) {
            return null;
        }
        return DataPermissionRespDTO.fromDataPermission(dataPermission, dataPermissionField);

    }

}
