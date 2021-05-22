package com.weweibuy.upms.user.model.ldap;

import lombok.Data;

@Data
public class LdapUser {


    /**
     * 用户名
     */
    private String username;

    /**
     * 姓名
     */
    private String commonName;

    /**
     * 姓
     */
    private String surname;

    /**
     * 密码
     */
    private String password;

}