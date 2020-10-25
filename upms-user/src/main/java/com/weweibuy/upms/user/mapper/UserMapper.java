package com.weweibuy.upms.user.mapper;

import com.weweibuy.upms.user.model.example.UserExample;
import com.weweibuy.upms.user.model.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    User selectOneByExample(UserExample example);

    User selectOneByExampleForUpdate(UserExample example);

    List<User> selectByExampleForUpdate(UserExample example);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}