package com.weweibuy.upms.permission.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.permission.model.dto.req.DataPermissionReqDTO;
import com.weweibuy.upms.permission.model.dto.req.UserAuthorizationReqDTO;
import com.weweibuy.upms.permission.model.dto.resp.DataPermissionRespDTO;
import com.weweibuy.upms.permission.model.dto.resp.UserAuthorizationRespDTO;
import com.weweibuy.upms.permission.service.UserAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户鉴权 相关接口
 *
 * @author durenhao
 * @date 2021/1/24 11:24
 **/
@RestController
@RequestMapping("/user/authorization")
@RequiredArgsConstructor
public class UserAuthorizationController {

    private final UserAuthorizationService authenticationService;

    /**
     * 鉴权接口
     *
     * @param authorizationReq
     * @return
     */
    @PostMapping
    public CommonDataResponse<UserAuthorizationRespDTO> authorization(@RequestBody @Valid UserAuthorizationReqDTO authorizationReq) {
        return authenticationService.authorization(authorizationReq);
    }

    /**
     * 数据级权限接口
     *
     * @param dataPermissionReqDTO
     * @return
     */
    @PostMapping("/data")
    public CommonDataResponse<List<DataPermissionRespDTO>> dataAuthorization(@RequestBody @Valid DataPermissionReqDTO dataPermissionReqDTO) {
        return authenticationService.dataAuthorization(dataPermissionReqDTO);
    }

}
