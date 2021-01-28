package com.weweibuy.upms.app.mapper;

import com.weweibuy.upms.app.model.example.AppExample;
import com.weweibuy.upms.app.model.po.App;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppMapper {
    long countByExample(AppExample example);

    int deleteByExample(AppExample example);

    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectOneByExample(AppExample example);

    App selectOneByExampleForUpdate(AppExample example);

    List<App> selectByExampleForUpdate(AppExample example);

    List<App> selectByExample(AppExample example);

    App selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") App record, @Param("example") AppExample example);

    int updateByExample(@Param("record") App record, @Param("example") AppExample example);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
}