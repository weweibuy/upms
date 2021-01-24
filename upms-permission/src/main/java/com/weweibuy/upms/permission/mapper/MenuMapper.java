package com.weweibuy.upms.permission.mapper;

import com.weweibuy.upms.permission.model.example.MenuExample;
import com.weweibuy.upms.permission.model.po.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectOneByExample(MenuExample example);

    Menu selectOneByExampleForUpdate(MenuExample example);

    List<Menu> selectByExampleForUpdate(MenuExample example);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}