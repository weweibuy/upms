package com.weweibuy.upms.model.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2020/10/24 21:31
 **/
@Data
public class UserRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
