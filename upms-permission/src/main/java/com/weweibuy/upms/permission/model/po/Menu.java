package com.weweibuy.upms.permission.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Menu {
    /**
     * id
     */
    private Long id;

    /**
     * 菜单代码
     */
    private String menuCode;

    /**
     * 菜单描述
     */
    private String menuDesc;

    /**
     * 菜单类型
     */
    private String menuType;

    /**
     * 父菜单代码
     */
    private String parentMenuCode;

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