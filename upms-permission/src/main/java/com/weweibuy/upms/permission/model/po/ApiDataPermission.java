package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ApiDataPermission {
    /**
     * id
     */
    private Long id;

    /**
     * 数据名
     */
    private String dataCode;

    /**
     * 用户标识
     */
    private String userSymbol;

    /**
     * 标识类型(0: 用户; 1: 用户组)
     */
    private Integer symbolType;

    /**
     * 数据值(_UNLIMIT:表示不限制)
     */
    private String dataValue;

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