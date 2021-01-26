package com.weweibuy.upms.permission.model.dto.req;

import lombok.Data;
import org.springframework.http.HttpMethod;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 数据级权限请求
 *
 * @author durenhao
 * @date 2021/1/26 21:22
 **/
@Data
public class DataPermissionReqDTO {

    @NotBlank
    private String service;

    @NotBlank
    private String path;

    @NotNull
    private HttpMethod httpMethod;

    @NotBlank
    private String username;

}
