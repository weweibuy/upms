package com.weweibuy.upms.repository;

import com.weweibuy.upms.mapper.UserGroupMapper;
import com.weweibuy.upms.model.example.UserGroupExample;
import com.weweibuy.upms.model.po.UserGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/24 21:37
 **/
@Repository
@RequiredArgsConstructor
public class UserGroupRepository {

    private final UserGroupMapper userGroupMapper;

    public List<UserGroup> selectByGroupKey(String groupKey) {
        return userGroupMapper.selectByExample(UserGroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andGroupKeyEqualTo(groupKey)
                .example());
    }

    public List<UserGroup> selectByGroupKey(List<String> groupKeyList) {
        return userGroupMapper.selectByExample(UserGroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andGroupKeyIn(groupKeyList)
                .example());
    }

    public List<UserGroup> selectByUserName(String username) {
        return userGroupMapper.selectByExample(UserGroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andUserNameEqualTo(username)
                .example());
    }

    public List<UserGroup> selectByUserName(List<String> usernameList) {
        return userGroupMapper.selectByExample(UserGroupExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andUserNameIn(usernameList)
                .example());
    }

}
