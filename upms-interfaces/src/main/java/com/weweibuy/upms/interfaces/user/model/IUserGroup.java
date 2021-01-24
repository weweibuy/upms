package com.weweibuy.upms.interfaces.user.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/1/24 21:54
 **/
@Data
public class IUserGroup {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 组代码
     */
    private String groupCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
