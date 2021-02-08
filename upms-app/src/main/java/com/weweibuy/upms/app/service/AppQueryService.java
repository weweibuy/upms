package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.utils.BeanCopyUtils;
import com.weweibuy.upms.app.model.dto.resp.AppRespDTO;
import com.weweibuy.upms.app.repository.AppRepository;
import com.weweibuy.upms.app.repository.AppTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2021/1/31 13:28
 **/
@Service
@RequiredArgsConstructor
public class AppQueryService {

    private final AppRepository appRepository;

    private final AppTokenRepository appTokenRepository;

    public AppRespDTO queryByAppId(String appId) {
        return appRepository.selectApp(appId)
                .map(a -> BeanCopyUtils.copy(a, AppRespDTO.class))
                .orElse(null);
    }

    public AppRespDTO queryByAccessToken(String accessToken) {
        return appTokenRepository.selectToken(accessToken)
                .map(a -> queryByAppId(a.getAppId()))
                .orElse(null);
    }
}
