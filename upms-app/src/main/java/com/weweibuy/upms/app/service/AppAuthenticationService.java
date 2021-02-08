package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.utils.IdWorker;
import com.weweibuy.framework.common.core.utils.OptionalEnhance;
import com.weweibuy.upms.app.config.AppAuthenticationProperties;
import com.weweibuy.upms.app.model.dto.req.AppAccessTokenReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppAccessTokenRespDTO;
import com.weweibuy.upms.app.model.po.App;
import com.weweibuy.upms.app.model.po.AppToken;
import com.weweibuy.upms.app.repository.AppRepository;
import com.weweibuy.upms.app.repository.AppTokenRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 认证相关服务
 *
 * @author durenhao
 * @date 2021/2/8 21:27
 **/
@Service
@RequiredArgsConstructor
public class AppAuthenticationService {

    private final AppRepository appRepository;

    private final AppTokenRepository appTokenRepository;

    private final AppAuthenticationProperties appAuthenticationProperties;

    public AppAccessTokenRespDTO authentication(AppAccessTokenReqDTO accessTokenRepDTO) {
        return OptionalEnhance.fromOptional(appRepository.selectApp(accessTokenRepDTO.getAppId()))
                .filter(app -> accessTokenRepDTO.validateAppSecret(app))
                .map(this::buildToken)
                .peek(appTokenRepository::insertToken)
                .map(AppAccessTokenRespDTO::fromAppToken)
                // TODO 认证失败
                .orElseThrow(() -> Exceptions.unknown());
    }


    private AppToken buildToken(App app) {
        AppToken appToken = new AppToken();
        String token = DigestUtils.md5Hex(IdWorker.nextStringId());
        appToken.setAccessToken(token);
        appToken.setAppId(app.getAppId());
        LocalDateTime accessTokenExpireAt = LocalDateTime.now().plusMinutes(appAuthenticationProperties.getTokenEffectiveMin());
        appToken.setAccessTokenExpireAt(accessTokenExpireAt);
        return appToken;

    }
}
