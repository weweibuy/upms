package com.weweibuy.upms.user.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.api.user.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.UserRespDTO;
import com.weweibuy.upms.user.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author durenhao
 * @date 2020/10/24 21:15
 **/
@RequestMapping("/user/query")
@RestController
@RequiredArgsConstructor
public class UserQueryController {

    private final UserQueryService userQueryService;

    @GetMapping
    public CommonDataResponse<UserRespDTO> queryUser(String username) {
        return Optional.ofNullable(username)
                .filter(StringUtils::isNotBlank)
                .map(userQueryService::queryUser)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(null));
    }

    @GetMapping("/list")
    public CommonDataResponse<List<UserRespDTO>> queryUser(UserQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(queryReqDTO)
                .filter(dto -> !dto.isAllEmpty())
                .map(userQueryService::queryUser)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(Collections.emptyList()));
    }

    @GetMapping("/count")
    public CommonDataResponse<Long> countUser(UserQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(queryReqDTO)
                .filter(dto -> !dto.isAllEmpty())
                .map(userQueryService::countUser)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(0L));
    }


}
