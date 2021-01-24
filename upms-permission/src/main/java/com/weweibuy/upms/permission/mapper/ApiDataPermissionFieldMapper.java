package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.ApiDataPermissionFieldExample;
import com.weweibuy.upms.permission.model.po.ApiDataPermissionField;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApiDataPermissionFieldMapper {
    long countByExample(ApiDataPermissionFieldExample example);

    int deleteByExample(ApiDataPermissionFieldExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ApiDataPermissionField record);

    int insertSelective(ApiDataPermissionField record);

    ApiDataPermissionField selectOneByExample(ApiDataPermissionFieldExample example);

    ApiDataPermissionField selectOneByExampleForUpdate(ApiDataPermissionFieldExample example);

    List<ApiDataPermissionField> selectByExampleForUpdate(ApiDataPermissionFieldExample example);

    List<ApiDataPermissionField> selectByExample(ApiDataPermissionFieldExample example);

    ApiDataPermissionField selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ApiDataPermissionField record, @Param("example") ApiDataPermissionFieldExample example);

    int updateByExample(@Param("record") ApiDataPermissionField record, @Param("example") ApiDataPermissionFieldExample example);

    int updateByPrimaryKeySelective(ApiDataPermissionField record);

    int updateByPrimaryKey(ApiDataPermissionField record);
}