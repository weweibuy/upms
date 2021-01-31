package com.weweibuy.upms.app.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.app.model.dto.req.AppGenerateReqDTO;
import com.weweibuy.upms.app.model.dto.resp.AppRespDTO;
import com.weweibuy.upms.app.service.AppManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author durenhao
 * @date 2021/1/31 14:14
 **/
@RestController
@RequestMapping("/app/manage")
@RequiredArgsConstructor
public class AppManagerController {

    private final AppManagerService appManagerService;

    @PostMapping("/generate")
    public CommonDataResponse<AppRespDTO> generateApp(@RequestBody @Valid AppGenerateReqDTO generateReqDTO) {
        AppRespDTO appRespDTO = appManagerService.generateApp(generateReqDTO);
        return CommonDataResponse.success(appRespDTO);
    }

}
