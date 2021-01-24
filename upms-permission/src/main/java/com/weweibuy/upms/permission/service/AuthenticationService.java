package com.weweibuy.upms.permission.service;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.framework.common.core.model.eum.CommonErrorCodeEum;
import com.weweibuy.upms.permission.manager.PermissionInfoQueryManager;
import com.weweibuy.upms.permission.manager.TokenManager;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReq;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationResp;
import com.weweibuy.upms.permission.model.po.Api;
import com.weweibuy.upms.permission.model.vo.TokenUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 鉴权服务
 *
 * @author durenhao
 * @date 2021/1/24 20:59
 **/
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenManager tokenManager;

    private final PermissionInfoQueryManager permissionInfoQueryManager;


    public CommonDataResponse<UserAuthorizationResp> authentication(UserAuthorizationReq req) {
        TokenUserInfo tokenUserInfo = null;
        try {
            tokenUserInfo = tokenManager.tokenToUserInfo(req.getAuthorization());
        } catch (Exception e) {
            return CommonDataResponse.response(CommonErrorCodeEum.UNAUTHORIZED, null);
        }

        String username = tokenUserInfo.getUsername();

        List<Api> apiList = permissionInfoQueryManager.queryAuthorizedApi(username);
        return apiList.stream()
                .filter(a -> a.getApiService().equals(req.getService()))
                .filter(a -> a.getApiAddress().equals(req.getPath()))
                .filter(a -> a.getApiMethod().equals(req.getHttpMethod().toString()))
                .findFirst()
                .map(a -> CommonDataResponse.success(UserAuthorizationResp.fromUsername(username)))
                .orElseGet(() -> CommonDataResponse.response(CommonErrorCodeEum.FORBIDDEN, UserAuthorizationResp.fromUsername(username)));


    }

}
