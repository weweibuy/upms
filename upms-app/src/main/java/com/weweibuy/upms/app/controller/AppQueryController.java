package com.weweibuy.upms.app.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.app.model.dto.resp.AppRespDTO;
import com.weweibuy.upms.app.service.AppQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author durenhao
 * @date 2021/1/31 13:26
 **/
@RestController
@RequestMapping("/app/query")
@RequiredArgsConstructor
public class AppQueryController {

    private final AppQueryService appQueryService;

    @GetMapping("/key")
    public CommonDataResponse<AppRespDTO> queryByAppKey(String appId) {
        return Optional.ofNullable(appId)
                .map(appQueryService::queryByAppId)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(null));
    }


}
