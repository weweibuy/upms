package com.weweibuy.upms.user.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String fullName;

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
     * 用户类型
     */
    private String userType;

    /**
     * 是否删除
     */
    private Boolean deleted;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}