package com.weweibuy.upms.user.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author durenhao
 * @date 2021/5/22 18:12
 **/
@Data
public class LoginReqDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
