package com.weweibuy.upms.permission.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.permission.model.dto.req.DataPermissionReqDTO;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReqDTO;
import com.weweibuy.upms.permission.model.dto.resp.DataPermissionRespDTO;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationRespDTO;
import com.weweibuy.upms.permission.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public CommonDataResponse<UserAuthorizationRespDTO> authentication(@RequestBody @Valid UserAuthorizationReqDTO authorizationReq) {
        return authenticationService.authentication(authorizationReq);
    }

    @PostMapping("/data")
    public CommonDataResponse<List<DataPermissionRespDTO>> dataPermission(@RequestBody @Valid DataPermissionReqDTO dataPermissionReqDTO) {
        authenticationService.dataPermission(dataPermissionReqDTO);
        return null;
    }

}
