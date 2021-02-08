package com.weweibuy.upms.app.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author durenhao
 * @date 2021/2/8 21:36
 **/
@Configuration
@EnableConfigurationProperties({AppAuthenticationProperties.class})
public class UpmsAppConfig {
}
