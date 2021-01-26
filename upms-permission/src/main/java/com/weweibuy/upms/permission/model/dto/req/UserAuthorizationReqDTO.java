package com.weweibuy.upms.permission.model.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户鉴权请求
 *
 * @author durenhao
 * @date 2020/12/27 17:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthorizationReqDTO {

    @NotBlank
    private String service;

    @NotBlank
    private String path;

    @NotNull
    private HttpMethod httpMethod;

    @NotBlank
    private String authorization;

}
