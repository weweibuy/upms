package com.weweibuy.upms.app.mapper;

import com.weweibuy.upms.app.model.example.AppTokenExample;
import com.weweibuy.upms.app.model.po.AppToken;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppTokenMapper {
    long countByExample(AppTokenExample example);

    int deleteByExample(AppTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppToken record);

    int insertSelective(AppToken record);

    AppToken selectOneByExample(AppTokenExample example);

    AppToken selectOneByExampleForUpdate(AppTokenExample example);

    List<AppToken> selectByExampleForUpdate(AppTokenExample example);

    List<AppToken> selectByExample(AppTokenExample example);

    AppToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByExample(@Param("record") AppToken record, @Param("example") AppTokenExample example);

    int updateByPrimaryKeySelective(AppToken record);

    int updateByPrimaryKey(AppToken record);
}