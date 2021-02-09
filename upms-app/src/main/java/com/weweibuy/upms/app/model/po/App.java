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
     * app_id(即client_id)
     */
    private String appId;

    /**
     * app_name
     */
    private String appName;

    /**
     * app_secret(即:client_secret;  AES密文)
     */
    private String appSecret;

    /**
     * 加密key(给客户AES加密,app_secret用, 密文)
     */
    private String encryptKey;

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