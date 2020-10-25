package com.weweibuy.upms.user.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Group {
    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 组名
     */
    private String groupKey;

    /**
     * 组描述
     */
    private String groupDesc;

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