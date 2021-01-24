package com.weweibuy.upms.permission.manager;

import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author durenhao
 * @date 2021/1/24 21:26
 **/
@Component
@RequiredArgsConstructor
public class TokenManager {

    public String generate(TokenUserInfo userInfo) {
        return "";
    }

    public TokenUserInfo tokenToUserInfo(String token) {
        TokenUserInfo tokenUserInfo = new TokenUserInfo();
        return tokenUserInfo;
    }

}
