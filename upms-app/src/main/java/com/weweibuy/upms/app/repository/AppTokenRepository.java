package com.weweibuy.upms.app.repository;

import com.weweibuy.upms.app.mapper.AppTokenMapper;
import com.weweibuy.upms.app.model.example.AppTokenExample;
import com.weweibuy.upms.app.model.po.AppToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * app token
 *
 * @author durenhao
 * @date 2021/2/7 22:16
 **/
@Repository
@RequiredArgsConstructor
public class AppTokenRepository {

    private final AppTokenMapper appTokenMapper;


    public Optional<AppToken> selectToken(String accessToken) {
        return Optional.ofNullable(appTokenMapper.selectOneByExample(
                AppTokenExample.newAndCreateCriteria()
                        .andDeletedEqualTo(false)
                        .andAccessTokenEqualTo(accessToken)
                        .example()
                        .orderBy("id desc")));
    }


    public int insertToken(AppToken appToken) {
        return appTokenMapper.insert(appToken);
    }


}
