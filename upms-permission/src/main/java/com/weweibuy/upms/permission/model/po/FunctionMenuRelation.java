package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FunctionMenuRelation {
    /**
     * id
     */
    private Long id;

    /**
     * 功能名
     */
    private String functionCode;

    /**
     * 菜单代码
     */
    private String menuCode;

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