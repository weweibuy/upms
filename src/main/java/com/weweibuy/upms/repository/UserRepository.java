package com.weweibuy.upms.repository;

import com.weweibuy.upms.mapper.UserMapper;
import com.weweibuy.upms.model.example.UserExample;
import com.weweibuy.upms.model.po.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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


}
