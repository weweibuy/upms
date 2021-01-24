package com.weweibuy.upms.permission.repository;

import com.weweibuy.upms.permission.mapper.FunctionMapper;
import com.weweibuy.upms.permission.mapper.FunctionPermissionMapper;
import com.weweibuy.upms.permission.model.eum.UserSymbolTypeEum;
import com.weweibuy.upms.permission.model.example.FunctionExample;
import com.weweibuy.upms.permission.model.example.FunctionPermissionExample;
import com.weweibuy.upms.permission.model.po.Function;
import com.weweibuy.upms.permission.model.po.FunctionPermission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 功能仓库
 *
 * @author durenhao
 * @date 2021/1/24 21:34
 **/
@Repository
@RequiredArgsConstructor
public class FunctionRepository {

    private final FunctionMapper functionMapper;

    private final FunctionPermissionMapper functionPermissionMapper;


    public List<FunctionPermission> selectFunctionPermission(List<String> userSymbolList, UserSymbolTypeEum userSymbolType) {
        return functionPermissionMapper.selectByExample(FunctionPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andUserSymbolIn(userSymbolList)
                .andSymbolTypeEqualTo(userSymbolType.toString())
                .example());
    }

    public List<FunctionPermission> selectFunctionPermission(String userSymbol, UserSymbolTypeEum userSymbolType) {
        return functionPermissionMapper.selectByExample(FunctionPermissionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andUserSymbolEqualTo(userSymbol)
                .andSymbolTypeEqualTo(userSymbolType.toString())
                .example());
    }


    public List<Function> selectFunction(List<String> functionCodeList) {
        return functionMapper.selectByExample(FunctionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andFunctionCodeIn(functionCodeList)
                .example());
    }

    public Optional<Function> selectFunction(String functionCode) {
        return Optional.ofNullable(functionMapper.selectOneByExample(FunctionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andFunctionCodeEqualTo(functionCode)
                .example()));
    }

    public Optional<Function> selectChildFunction(String functionCode) {
        return Optional.ofNullable(functionMapper.selectOneByExample(FunctionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andParentFunctionCodeEqualTo(functionCode)
                .example()));
    }


    public List<Function> selectChildFunction(List<String> functionCodeList) {
        return functionMapper.selectByExample(FunctionExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andParentFunctionCodeIn(functionCodeList)
                .example());
    }

}
