package com.weweibuy.upms.app.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.upms.app.model.dto.req.AppAuthorizationReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppAuthorizationRespDTO;
import com.weweibuy.upms.app.model.po.App;
import com.weweibuy.upms.app.model.po.AppApiRelation;
import com.weweibuy.upms.app.repository.AppRepository;
import com.weweibuy.upms.interfaces.api.IApiQueryService;
import com.weweibuy.upms.interfaces.api.model.IApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author durenhao
 * @date 2021/1/28 22:14
 **/
@Service
@RequiredArgsConstructor
public class AppAuthenticationService {

    private final AppRepository appRepository;

    private final IApiQueryService iApiQueryService;

    public CommonDataResponse<AppAuthorizationRespDTO> appAuthentication(AppAuthorizationReqDTO reqDTO) {
        String appKey = reqDTO.getAppKey();
        App app = appRepository.selectApp(appKey)
                .orElse(null);
        if (app == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null);
        }
        IApi api = iApiQueryService.queryApi(reqDTO.getService(), reqDTO.getPath(), reqDTO.getHttpMethod())
                .orElse(null);
        if (api == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, null);
        }
        AppApiRelation appApiRelation = appRepository.selectAppApi(appKey, api.getApiCode())
                .orElse(null);
        if (appApiRelation == null) {
            return CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, null);
        }
        AppAuthorizationRespDTO authorizationRespDTO = AppAuthorizationRespDTO.appAuthorizationRespDTO(reqDTO, app);
        return CommonDataResponse.success(authorizationRespDTO);

    }
}
