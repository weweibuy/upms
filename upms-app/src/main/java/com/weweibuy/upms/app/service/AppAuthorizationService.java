package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.upms.app.model.dto.req.AppAuthorizationReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppAuthorizationRespDTO;
import com.weweibuy.upms.app.model.po.App;
import com.weweibuy.upms.app.model.po.AppApiRelation;
import com.weweibuy.upms.app.model.po.AppToken;
import com.weweibuy.upms.app.repository.AppRepository;
import com.weweibuy.upms.app.repository.AppTokenRepository;
import com.weweibuy.upms.interfaces.api.IApiQueryService;
import com.weweibuy.upms.interfaces.api.model.IApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/1/28 22:14
 **/
@Service
@RequiredArgsConstructor
public class AppAuthorizationService {

    private final AppRepository appRepository;

    private final IApiQueryService iApiQueryService;

    private final AppTokenRepository appTokenRepository;

    public CommonDataResponse<AppAuthorizationRespDTO> appAuthorization(AppAuthorizationReqDTO reqDTO) {
        String accessToken = reqDTO.getAccessToken();
        AppToken appToken = appTokenRepository.selectToken(accessToken)
                .orElse(null);
        if (appToken == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null);
        }
        if (appToken.getAccessTokenExpireAt().compareTo(LocalDateTime.now()) <= 0) {
            return CommonDataResponse.response(CommonErrorCodeEum.TOKEN_INVALID, null);
        }

        String appId = appToken.getAppId();
        App app = appRepository.selectApp(appId)
                .orElse(null);
        if (app == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null);
        }
        IApi api = iApiQueryService.queryApi(reqDTO.getService(), reqDTO.getPath(), reqDTO.getHttpMethod())
                .orElse(null);
        if (api == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, null);
        }
        AppApiRelation appApiRelation = appRepository.selectAppApi(appId, api.getApiCode())
                .orElse(null);
        if (appApiRelation == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, null);
        }
        AppAuthorizationRespDTO authorizationRespDTO = AppAuthorizationRespDTO.appAuthorizationRespDTO(reqDTO, app);
        return CommonDataResponse.success(authorizationRespDTO);

    }
}
