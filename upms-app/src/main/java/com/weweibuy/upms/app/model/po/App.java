package com.weweibuy.upms.app.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class App {
    /**
     * id
     */
    private Long id;

    /**
     * app_id
     */
    private String appId;

    /**
     * app_name
     */
    private String appName;

    /**
     * app_key
     */
    private String appKey;

    /**
     * app_secret
     */
    private String appSecret;

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