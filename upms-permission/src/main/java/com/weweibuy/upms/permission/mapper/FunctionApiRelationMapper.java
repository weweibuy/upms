package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.FunctionApiRelationExample;
import com.weweibuy.upms.permission.model.po.FunctionApiRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FunctionApiRelationMapper {
    long countByExample(FunctionApiRelationExample example);

    int deleteByExample(FunctionApiRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FunctionApiRelation record);

    int insertSelective(FunctionApiRelation record);

    FunctionApiRelation selectOneByExample(FunctionApiRelationExample example);

    FunctionApiRelation selectOneByExampleForUpdate(FunctionApiRelationExample example);

    List<FunctionApiRelation> selectByExampleForUpdate(FunctionApiRelationExample example);

    List<FunctionApiRelation> selectByExample(FunctionApiRelationExample example);

    FunctionApiRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FunctionApiRelation record, @Param("example") FunctionApiRelationExample example);

    int updateByExample(@Param("record") FunctionApiRelation record, @Param("example") FunctionApiRelationExample example);

    int updateByPrimaryKeySelective(FunctionApiRelation record);

    int updateByPrimaryKey(FunctionApiRelation record);
}