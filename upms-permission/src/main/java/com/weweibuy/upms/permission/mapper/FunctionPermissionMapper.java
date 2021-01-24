package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.FunctionPermissionExample;
import com.weweibuy.upms.permission.model.po.FunctionPermission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FunctionPermissionMapper {
    long countByExample(FunctionPermissionExample example);

    int deleteByExample(FunctionPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FunctionPermission record);

    int insertSelective(FunctionPermission record);

    FunctionPermission selectOneByExample(FunctionPermissionExample example);

    FunctionPermission selectOneByExampleForUpdate(FunctionPermissionExample example);

    List<FunctionPermission> selectByExampleForUpdate(FunctionPermissionExample example);

    List<FunctionPermission> selectByExample(FunctionPermissionExample example);

    FunctionPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByExample(@Param("record") FunctionPermission record, @Param("example") FunctionPermissionExample example);

    int updateByPrimaryKeySelective(FunctionPermission record);

    int updateByPrimaryKey(FunctionPermission record);
}