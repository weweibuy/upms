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

    private Long tokenEffectiveMin = 120L;

}
