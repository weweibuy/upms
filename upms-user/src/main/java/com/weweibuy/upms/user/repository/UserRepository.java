package com.weweibuy.upms.user.repository;

import com.weweibuy.upms.user.mapper.UserMapper;
import com.weweibuy.upms.user.model.example.UserExample;
import com.weweibuy.upms.user.model.po.User;
import com.weweibuy.upms.user.model.vo.UserQueryVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/24 21:24
 **/
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public Optional<User> selectUser(String username) {
        return Optional.ofNullable(userMapper.selectOneByExample(UserExample.newAndCreateCriteria()
                .andDeletedEqualTo(false)
                .andUsernameEqualTo(username)
                .example()));
    }


    public List<User> selectUser(UserQueryVO queryVO) {
        return userMapper.selectByExample(buildExample(queryVO));
    }


    public Long countUser(UserQueryVO queryVO) {
        return userMapper.countByExample(buildExample(queryVO));
    }

    private UserExample buildExample(UserQueryVO queryVO) {
        UserExample.Criteria criteria = UserExample.newAndCreateCriteria()
                .andDeletedEqualTo(false);
        Optional.ofNullable(queryVO.getUsername())
                .ifPresent(criteria::andUsernameEqualTo);
        Optional.ofNullable(queryVO.getNameLike())
                .ifPresent(like -> criteria.andUsernameLike("%" + like + "%"));
        Optional.ofNullable(queryVO.getPhoneNo())
                .ifPresent(criteria::andPhoneNoEqualTo);
        Optional.ofNullable(queryVO.getEmail())
                .ifPresent(criteria::andEmailEqualTo);
        Optional.ofNullable(queryVO.getUsernameList())
                .filter(CollectionUtils::isNotEmpty)
                .ifPresent(criteria::andUsernameIn);
        return criteria.example();
    }

}
