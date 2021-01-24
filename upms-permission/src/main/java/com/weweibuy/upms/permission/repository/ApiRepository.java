package com.weweibuy.upms.permission.repository;

import com.weweibuy.upms.permission.mapper.ApiMapper;
import com.weweibuy.upms.permission.mapper.FunctionApiRelationMapper;
import com.weweibuy.upms.permission.model.example.ApiExample;
import com.weweibuy.upms.permission.model.example.FunctionApiRelationExample;
import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.model.po.FunctionApiRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

    public List<Api> selectApi(List<String> apiCodeList) {
        return apiMapper.selectByExample(ApiExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andApiCodeIn(apiCodeList)
                .example());
    }


}
