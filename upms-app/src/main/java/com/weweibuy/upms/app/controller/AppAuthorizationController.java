package com.weweibuy.upms.app.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.app.model.dto.req.AppAuthorizationReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppAuthorizationRespDTO;
import com.weweibuy.upms.app.service.AppAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * app 鉴权相关接口
 *
 * @author durenhao
 * @date 2021/1/28 21:59
 **/
@RestController
@RequestMapping("/app/authorization")
@RequiredArgsConstructor
public class AppAuthorizationController {

    private final AppAuthorizationService appAuthenticationService;

    @PostMapping
    public CommonDataResponse<AppAuthorizationRespDTO> appAuthorization(@RequestBody @Valid AppAuthorizationReqDTO reqDTO) {
        return appAuthenticationService.appAuthorization(reqDTO);
    }

}
