package com.weweibuy.upms.app.model.po;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AppToken {
    /**
     * id
     */
    private Long id;

    /**
     * app_id(即client_id)
     */
    private String appId;

    /**
     * access_token
     */
    private String accessToken;

    /**
     * refresh_token
     */
    private String refreshToken;

    /**
     * access_token失效时间
     */
    private LocalDateTime accessTokenExpireAt;

    /**
     * refresh_token失效时间
     */
    private LocalDateTime refreshTokenExpireAt;

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