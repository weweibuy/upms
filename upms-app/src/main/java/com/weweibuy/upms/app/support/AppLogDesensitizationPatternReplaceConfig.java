package com.weweibuy.upms.app.support;


import com.weweibuy.framework.common.log.desensitization.PatternReplaceConfig;
import com.weweibuy.framework.common.log.desensitization.SensitizationMappingConfigurer;
import com.weweibuy.framework.common.log.logger.HttpLogger;
import org.springframework.http.HttpMethod;

/**
 * @author durenhao
 * @date 2020/3/1 23:37
 **/
public class AppLogDesensitizationPatternReplaceConfig implements PatternReplaceConfig {


    @Override
    public void addDesensitizationRule(SensitizationMappingConfigurer configurer) {
        configurer.http()
                .path("/app/authentication")
                .method(HttpMethod.POST)
                .logger(HttpLogger.class)
                .sensitizationField("appSecret");

    }
}
