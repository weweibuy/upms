package com.weweibuy.upms.user.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.user.model.dto.request.LoginReqDTO;
import com.weweibuy.upms.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2021/5/22 18:10
 **/
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public CommonDataResponse login(@RequestBody  LoginReqDTO loginReqDTO){
        boolean login = loginService.login(loginReqDTO);
        return CommonDataResponse.success(login);
    }

}
