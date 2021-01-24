package com.weweibuy.upms.user.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class UserGroup {
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