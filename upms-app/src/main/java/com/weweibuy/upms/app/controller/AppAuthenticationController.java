package com.weweibuy.upms.app.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.app.model.dto.req.AppAccessTokenReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppAccessTokenRespDTO;
import com.weweibuy.upms.app.service.AppAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 认证相关接口
 *
 * @author durenhao
 * @date 2021/2/4 22:23
 **/
@RestController
@RequestMapping("/app/authentication")
@RequiredArgsConstructor
public class AppAuthenticationController {

    private final AppAuthenticationService appAuthenticationService;

    /**
     * 获取token
     *
     * @param accessTokenRepDTO
     * @return
     */
    @PostMapping
    public CommonDataResponse authentication(@RequestBody @Valid AppAccessTokenReqDTO accessTokenRepDTO) {
        AppAccessTokenRespDTO tokenRespDTO = appAuthenticationService.authentication(accessTokenRepDTO);
        return CommonDataResponse.success(tokenRespDTO);
    }


}
