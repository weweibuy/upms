package com.weweibuy.upms.app.mapper;

import com.weweibuy.upms.app.model.example.AppApiRelationExample;
import com.weweibuy.upms.app.model.po.AppApiRelation;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppApiRelationMapper {
    long countByExample(AppApiRelationExample example);

    int deleteByExample(AppApiRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppApiRelation record);

    int insertSelective(AppApiRelation record);

    AppApiRelation selectOneByExample(AppApiRelationExample example);

    AppApiRelation selectOneByExampleForUpdate(AppApiRelationExample example);

    List<AppApiRelation> selectByExampleForUpdate(AppApiRelationExample example);

    List<AppApiRelation> selectByExample(AppApiRelationExample example);

    AppApiRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppApiRelation record, @Param("example") AppApiRelationExample example);

    int updateByExample(@Param("record") AppApiRelation record, @Param("example") AppApiRelationExample example);

    int updateByPrimaryKeySelective(AppApiRelation record);

    int updateByPrimaryKey(AppApiRelation record);
}