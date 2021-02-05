package com.weweibuy.upms.app.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AppApiRelation {
    /**
     * id
     */
    private Long id;

    /**
     * 接口代码
     */
    private String apiCode;

    /**
     * app_key
     */
    private String appId;

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