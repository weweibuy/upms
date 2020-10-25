package com.weweibuy.upms.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.model.dto.request.GroupQueryReqDTO;
import com.weweibuy.upms.model.dto.response.GroupRespDTO;
import com.weweibuy.upms.service.GroupQueryService;
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
 * @date 2020/10/25 9:17
 **/
@RestController
@RequestMapping("/group/query")
@RequiredArgsConstructor
public class GroupQueryController {

    private final GroupQueryService groupQueryService;

    @GetMapping
    public CommonDataResponse<GroupRespDTO> queryGroup(String username) {
        return Optional.ofNullable(username)
                .filter(StringUtils::isNotBlank)
                .map(groupQueryService::queryGroup)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(null));
    }

    @GetMapping("/list")
    public CommonDataResponse<List<GroupRespDTO>> queryGroup(GroupQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(queryReqDTO)
                .filter(GroupQueryReqDTO::isAllEmpty)
                .map(groupQueryService::queryGroup)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(Collections.emptyList()));
    }

    @GetMapping("/count")
    public CommonDataResponse<Long> countGroup(GroupQueryReqDTO queryReqDTO) {
        return Optional.ofNullable(queryReqDTO)
                .filter(GroupQueryReqDTO::isAllEmpty)
                .map(groupQueryService::countGroup)
                .map(CommonDataResponse::success)
                .orElse(CommonDataResponse.success(0L));
    }

}
