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
     * 组名
     */
    private String groupKey;

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