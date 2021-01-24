package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.FunctionMenuRelationExample;
import com.weweibuy.upms.permission.model.po.FunctionMenuRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FunctionMenuRelationMapper {
    long countByExample(FunctionMenuRelationExample example);

    int deleteByExample(FunctionMenuRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FunctionMenuRelation record);

    int insertSelective(FunctionMenuRelation record);

    FunctionMenuRelation selectOneByExample(FunctionMenuRelationExample example);

    FunctionMenuRelation selectOneByExampleForUpdate(FunctionMenuRelationExample example);

    List<FunctionMenuRelation> selectByExampleForUpdate(FunctionMenuRelationExample example);

    List<FunctionMenuRelation> selectByExample(FunctionMenuRelationExample example);

    FunctionMenuRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FunctionMenuRelation record, @Param("example") FunctionMenuRelationExample example);

    int updateByExample(@Param("record") FunctionMenuRelation record, @Param("example") FunctionMenuRelationExample example);

    int updateByPrimaryKeySelective(FunctionMenuRelation record);

    int updateByPrimaryKey(FunctionMenuRelation record);
}