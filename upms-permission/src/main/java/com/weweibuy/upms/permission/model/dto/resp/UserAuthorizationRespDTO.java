package com.weweibuy.upms.permission.model.dto.resp;

import lombok.Data;

/**
 * 用户 鉴权响应
 *
 * @author durenhao
 * @date 2020/12/27 17:38
 **/
@Data
public class UserAuthorizationRespDTO {

    private String username;


    public static UserAuthorizationRespDTO fromUsername(String username) {
        UserAuthorizationRespDTO userAuthorizationResp = new UserAuthorizationRespDTO();
        userAuthorizationResp.setUsername(username);
        return userAuthorizationResp;
    }

}
