package com.weweibuy.upms.user.mapper;

import com.weweibuy.upms.user.model.example.UserGroupExample;
import com.weweibuy.upms.user.model.po.UserGroup;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserGroupMapper {
    long countByExample(UserGroupExample example);

    int deleteByExample(UserGroupExample example);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectOneByExample(UserGroupExample example);

    UserGroup selectOneByExampleForUpdate(UserGroupExample example);

    List<UserGroup> selectByExampleForUpdate(UserGroupExample example);

    List<UserGroup> selectByExample(UserGroupExample example);

    int updateByExampleSelective(@Param("record") UserGroup record, @Param("example") UserGroupExample example);

    int updateByExample(@Param("record") UserGroup record, @Param("example") UserGroupExample example);
}