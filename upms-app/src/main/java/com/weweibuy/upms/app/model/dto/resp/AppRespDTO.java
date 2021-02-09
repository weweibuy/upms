package com.weweibuy.upms.app.model.dto.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author durenhao
 * @date 2021/1/31 13:28
 **/
@Data
public class AppRespDTO {

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
     * 加密key(给客户AES加密,app_secret用)
     */
    private String encryptKey;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
