package com.weweibuy.upms.permission.repository;

import com.weweibuy.upms.permission.mapper.ApiDataPermissionFieldMapper;
import com.weweibuy.upms.permission.mapper.ApiDataPermissionMapper;
import com.weweibuy.upms.permission.model.eum.UserSymbolTypeEum;
import com.weweibuy.upms.permission.model.example.ApiDataPermissionExample;
import com.weweibuy.upms.permission.model.example.ApiDataPermissionFieldExample;
import com.weweibuy.upms.permission.model.po.ApiDataPermission;
import com.weweibuy.upms.permission.model.po.ApiDataPermissionField;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * 接口数据权限 仓库
 *
 * @author durenhao
 * @date 2021/1/24 22:16
 **/
@Repository
@RequiredArgsConstructor
public class ApiDataPermissionRepository {

    private final ApiDataPermissionMapper apiDataPermissionMapper;

    private final ApiDataPermissionFieldMapper apiDataPermissionFieldMapper;

    public List<ApiDataPermissionField> selectField(String apiCode) {
        return apiDataPermissionFieldMapper.selectByExample(ApiDataPermissionFieldExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiCodeEqualTo(apiCode)
                .example());
    }


    public List<ApiDataPermissionField> selectField(List<String> apiCodeList) {
        if (CollectionUtils.isEmpty(apiCodeList)) {
            return Collections.emptyList();
        }
        return apiDataPermissionFieldMapper.selectByExample(ApiDataPermissionFieldExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiCodeIn(apiCodeList)
                .example());
    }


    public Optional<ApiDataPermission> selectDataPermission(String dataCode) {
        return Optional.ofNullable(apiDataPermissionMapper.selectOneByExample(ApiDataPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andDataCodeEqualTo(dataCode)
                .example()));
    }


    public List<ApiDataPermission> selectDataPermission(List<String> dataCodeList) {
        if (CollectionUtils.isEmpty(dataCodeList)) {
            return Collections.emptyList();
        }
        return apiDataPermissionMapper.selectByExample(ApiDataPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andDataCodeIn(dataCodeList)
                .example());
    }

    public List<ApiDataPermission> selectDataPermission(List<String> dataCodeList, String userSymbol, UserSymbolTypeEum symbolType) {
        return apiDataPermissionMapper.selectByExample(ApiDataPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andDataCodeIn(dataCodeList)
                .andUserSymbolEqualTo(userSymbol)
                .andSymbolTypeEqualTo(symbolType.getCode())
                .example());
    }

    public List<ApiDataPermission> selectDataPermission(List<String> dataCodeList, List<String> userSymbolList, UserSymbolTypeEum symbolType) {
        return apiDataPermissionMapper.selectByExample(ApiDataPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andDataCodeIn(dataCodeList)
                .andUserSymbolIn(userSymbolList)
                .andSymbolTypeEqualTo(symbolType.getCode())
                .example());
    }

}
