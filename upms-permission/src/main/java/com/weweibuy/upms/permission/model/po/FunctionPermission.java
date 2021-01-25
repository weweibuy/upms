package com.weweibuy.upms.permission.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FunctionPermission {
    /**
     * id
     */
    private Long id;

    /**
     * 用户标识
     */
    private String userSymbol;

    /**
     * 标识类型(0:用户; 1:用户组)
     */
    private Integer symbolType;

    /**
     * 功能代码
     */
    private String functionCode;

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