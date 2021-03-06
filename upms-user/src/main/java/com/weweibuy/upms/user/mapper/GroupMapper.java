package com.weweibuy.upms.user.mapper;

import com.weweibuy.upms.user.model.example.GroupExample;
import com.weweibuy.upms.user.model.po.Group;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectOneByExample(GroupExample example);

    Group selectOneByExampleForUpdate(GroupExample example);

    List<Group> selectByExampleForUpdate(GroupExample example);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}