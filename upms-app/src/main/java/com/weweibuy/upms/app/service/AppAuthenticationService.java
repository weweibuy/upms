package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.framework.common.core.utils.DateTimeUtils;
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
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

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
        App dbApp = OptionalEnhance.fromOptional(appRepository.selectApp(accessTokenRepDTO.getAppId()))
                .peek(app -> accessTokenRepDTO.validateAppSecret(app, appAuthenticationProperties))
                .orElseThrow(() -> Exceptions.responseStatusException(HttpStatus.UNAUTHORIZED, CommonErrorCodeEum.UNAUTHORIZED));

        return OptionalEnhance.ofNullable(appTokenRepository.select(dbApp.getAppId()))
                .filter(CollectionUtils::isNotEmpty)
                .flatMapOptional(list -> list.stream().sorted(Comparator.comparing(AppToken::getAccessTokenExpireAt).reversed())
                        .findFirst())
                .filter(token -> DateTimeUtils.isOverInterval(token.getAccessTokenExpireAt(), LocalDateTime.now(),
                        appAuthenticationProperties.getApplyNextTokenIntervalMin(), TimeUnit.MINUTES))
                .map(AppAccessTokenRespDTO::fromAppToken)
                .orElseGet(() -> AppAccessTokenRespDTO.fromAppToken(buildAndInsertToken(dbApp)));
    }


    public AppToken buildAndInsertToken(App app) {
        AppToken appToken = buildToken(app);
        // TODO 加锁控制

        appTokenRepository.insertToken(appToken);
        return appToken;
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
