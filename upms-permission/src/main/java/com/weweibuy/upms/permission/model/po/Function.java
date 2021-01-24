package com.weweibuy.upms.permission.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Function {
    /**
     * id
     */
    private Long id;

    /**
     * 功能名
     */
    private String functionCode;

    /**
     * 功能描述
     */
    private String functionDesc;

    /**
     * 父功代码
     */
    private String parentFunctionCode;

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