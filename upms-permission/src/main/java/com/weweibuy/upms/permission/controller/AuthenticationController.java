package com.weweibuy.upms.permission.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReq;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationResp;
import com.weweibuy.upms.permission.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author durenhao
 * @date 2021/1/24 11:24
 **/
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authentication")
    public CommonDataResponse<UserAuthorizationResp> authentication(@RequestBody @Valid UserAuthorizationReq authorizationReq) {
        UserAuthorizationResp userAuthorizationResp = new UserAuthorizationResp();
        userAuthorizationResp.setUsername("tom");
        return CommonDataResponse.success(userAuthorizationResp);
    }


}
