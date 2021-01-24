package com.weweibuy.upms.permission.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReq;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationResp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2021/1/24 11:24
 **/
@RestController
@RequestMapping("/permission")
public class UserPermissionController {


    @PostMapping("/authentication")
    public CommonDataResponse<UserAuthorizationResp> authentication(@RequestBody UserAuthorizationReq authorizationReq) {
        UserAuthorizationResp userAuthorizationResp = new UserAuthorizationResp();
        userAuthorizationResp.setUsername("tom");
        return CommonDataResponse.success(userAuthorizationResp);
    }


}
