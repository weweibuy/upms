package com.weweibuy.upms.api.user;

import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.api.user.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.UserRespDTO;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/24 21:18
 **/
@RequestMapping("/user/query")
public interface UserQueryApi {

    @GetMapping
    CommonDataResponse<UserRespDTO> queryUser(@RequestParam("username") String username);

    @GetMapping("/list")
    CommonDataResponse<List<UserRespDTO>> queryUser(@SpringQueryMap UserQueryReqDTO queryReqDTO);

    @GetMapping("/count")
    CommonDataResponse<Long> countUser(@SpringQueryMap UserQueryReqDTO queryReqDTO);

}
