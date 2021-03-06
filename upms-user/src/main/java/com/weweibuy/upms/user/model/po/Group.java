package com.weweibuy.upms.user.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Group {
    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String groupName;

    /**
     * 组代码
     */
    private String groupCode;

    /**
     * 组描述
     */
    private String groupDesc;

    /**
     * 组类型
     */
    private String groupType;

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