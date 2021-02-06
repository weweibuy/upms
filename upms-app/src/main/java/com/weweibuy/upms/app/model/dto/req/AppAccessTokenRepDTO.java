package com.weweibuy.upms.app.model.dto.req;

import lombok.Data;

/**
 * 获取 token请求
 *
 * @author durenhao
 * @date 2021/2/6 11:25
 **/
@Data
public class AppAccessTokenRepDTO {

    private String appId;

    private String appSecret;


    private String grantType;

    private String redirectUri;

    private String code;


}
