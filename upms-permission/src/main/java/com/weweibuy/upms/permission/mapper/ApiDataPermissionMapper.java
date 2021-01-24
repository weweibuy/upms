package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.ApiDataPermissionExample;
import com.weweibuy.upms.permission.model.po.ApiDataPermission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiDataPermissionMapper {
    long countByExample(ApiDataPermissionExample example);

    int deleteByExample(ApiDataPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApiDataPermission record);

    int insertSelective(ApiDataPermission record);

    ApiDataPermission selectOneByExample(ApiDataPermissionExample example);

    ApiDataPermission selectOneByExampleForUpdate(ApiDataPermissionExample example);

    List<ApiDataPermission> selectByExampleForUpdate(ApiDataPermissionExample example);

    List<ApiDataPermission> selectByExample(ApiDataPermissionExample example);

    ApiDataPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApiDataPermission record, @Param("example") ApiDataPermissionExample example);

    int updateByExample(@Param("record") ApiDataPermission record, @Param("example") ApiDataPermissionExample example);

    int updateByPrimaryKeySelective(ApiDataPermission record);

    int updateByPrimaryKey(ApiDataPermission record);
}