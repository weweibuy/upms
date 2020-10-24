package com.weweibuy.upms.controller;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.model.dto.request.UserRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author durenhao
 * @date 2020/10/24 21:15
 **/
@RequestMapping("/user/query")
@RestController
public class UserQueryController {

    @GetMapping
    public CommonDataResponse<UserRespDTO> queryUser(String username) {
        return null;
    }


}
