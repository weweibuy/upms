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

    @NotNull(message = "httpMethod不能为空")
    private HttpMethod httpMethod;

    @NotBlank(message = "path不能为空")
    private String path;

    @NotBlank(message = "service不能为空")
    private String service;

    @NotBlank(message = "accessToken不能为空")
    private String accessToken;

}
