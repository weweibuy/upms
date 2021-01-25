package com.weweibuy.upms.permission.manager;

import com.weweibuy.framework.common.codec.KeyUtils;
import com.weweibuy.framework.common.codec.jwt.JwtUtils;
import com.weweibuy.framework.common.core.utils.JackJsonUtils;
import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * @author durenhao
 * @date 2021/1/24 21:26
 **/
@Component
@RequiredArgsConstructor
public class TokenManager {

    private static final String SALT = "123456";

    private static Key key;

    static {
        key = KeyUtils.generalHS256Key(SALT);
    }

    public String generate(TokenUserInfo userInfo) {
        BeanMap beanMap = BeanMap.create(userInfo);
        return JwtUtils.encode(key, SignatureAlgorithm.HS256, beanMap);
    }

    public TokenUserInfo tokenToUserInfo(String token) {
        Jwt<Header, Object> parser = JwtUtils.parser(key, token);
        Object body = parser.getBody();
        String write = JackJsonUtils.write(body);
        return JackJsonUtils.readValue(write, TokenUserInfo.class);
    }


}
