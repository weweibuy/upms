package com.weweibuy.upms.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author durenhao
 * @date 2021/2/8 21:36
 **/
@ConfigurationProperties
@Data
public class AppAuthenticationProperties {

    /**
     * Token 有效时间
     */
    private Long tokenEffectiveMin = 120L;

    /**
     * token 过期前 多少分钟可以申请下一个 token
     */
    private Long applyNextTokenIntervalMin = 2L;

    /**
     * 申请 token 校验 时间间隔最大值
     */
    private Long applyTokenTimeIntervalMills = 1000000000L;


}
