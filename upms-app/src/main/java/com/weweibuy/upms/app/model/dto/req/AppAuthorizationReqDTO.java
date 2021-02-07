package com.weweibuy.upms.app.model.dto.req;

import lombok.Data;
import org.springframework.http.HttpMethod;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * App 鉴权请求
 *
 * @author durenhao
 * @date 2020/2/24 21:24
 **/
@Data
public class AppAuthorizationReqDTO {

    @NotNull
    private HttpMethod httpMethod;

    @NotBlank
    private String path;

    @NotBlank
    private String service;

    @NotBlank
    private String accessToken;

}
