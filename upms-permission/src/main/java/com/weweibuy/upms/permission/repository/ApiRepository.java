package com.weweibuy.upms.permission.repository;

import com.weweibuy.upms.permission.mapper.ApiMapper;
import com.weweibuy.upms.permission.mapper.FunctionApiRelationMapper;
import com.weweibuy.upms.permission.model.example.ApiExample;
import com.weweibuy.upms.permission.model.example.FunctionApiRelationExample;
import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.model.po.FunctionApiRelation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * api 接口数据操作
 *
 * @author durenhao
 * @date 2021/1/24 21:36
 **/
@Repository
@RequiredArgsConstructor
public class ApiRepository {

    private final ApiMapper apiMapper;

    private final FunctionApiRelationMapper functionApiRelationMapper;


    public List<FunctionApiRelation> selectFunctionApiRelation(String functionCode) {
        return functionApiRelationMapper.selectByExample(FunctionApiRelationExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andFunctionCodeEqualTo(functionCode)
                .example());
    }


    public List<FunctionApiRelation> selectFunctionApiRelation(List<String> functionCodeList) {
        if (CollectionUtils.isEmpty(functionCodeList)) {
            return Collections.emptyList();
        }
        return functionApiRelationMapper.selectByExample(FunctionApiRelationExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andFunctionCodeIn(functionCodeList)
                .example());
    }


    public Optional<Api> selectApi(String apiCode) {
        return Optional.ofNullable(apiMapper.selectOneByExample(ApiExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiCodeEqualTo(apiCode)
                .example()));
    }

    public Optional<Api> selectApi(String service, String path, HttpMethod httpMethod) {
        return Optional.ofNullable(apiMapper.selectOneByExample(ApiExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiServiceEqualTo(service)
                .andApiAddressEqualTo(path)
                .andApiMethodEqualTo(httpMethod.toString())
                .example()));
    }


    public List<Api> selectApi(List<String> apiCodeList) {
        if (CollectionUtils.isEmpty(apiCodeList)) {
            return Collections.emptyList();
        }
        return apiMapper.selectByExample(ApiExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiCodeIn(apiCodeList)
                .example());
    }


}
