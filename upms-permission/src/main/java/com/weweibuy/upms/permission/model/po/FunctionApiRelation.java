package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FunctionApiRelation {
    /**
     * id
     */
    private Long id;

    /**
     * 接口名
     */
    private String apiName;

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