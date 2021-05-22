package com.weweibuy.upms.user.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.DirContextAuthenticationStrategy;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.pool2.factory.MutablePooledContextSource;
import org.springframework.ldap.pool2.factory.PoolConfig;

import java.util.Collections;

/**
 * @author durenhao
 * @date 2021/5/22 23:52
 **/
@Configuration
public class UpmsLdapConfig {

    @Bean
    public LdapContextSource ldapContextSource(LdapProperties properties, Environment environment,
                                           ObjectProvider<DirContextAuthenticationStrategy> dirContextAuthenticationStrategy) {
        LdapContextSource source = new LdapContextSource();
        dirContextAuthenticationStrategy.ifUnique(source::setAuthenticationStrategy);
        PropertyMapper propertyMapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        propertyMapper.from(properties.getUsername()).to(source::setUserDn);
        propertyMapper.from(properties.getPassword()).to(source::setPassword);
        propertyMapper.from(properties.getAnonymousReadOnly()).to(source::setAnonymousReadOnly);
        propertyMapper.from(properties.getBase()).to(source::setBase);
        propertyMapper.from(properties.determineUrls(environment)).to(source::setUrls);
        propertyMapper.from(properties.getBaseEnvironment()).to(
                (baseEnvironment) -> source.setBaseEnvironmentProperties(Collections.unmodifiableMap(baseEnvironment)));

        return source;
    }

    @Bean
    public MutablePooledContextSource poolContextSource(LdapContextSource ldapContextSource){
        PoolConfig poolConfig = new PoolConfig();
        MutablePooledContextSource mutablePooledContextSource =
                new MutablePooledContextSource(poolConfig);
        mutablePooledContextSource.setContextSource(ldapContextSource);
        return  mutablePooledContextSource;
    }


    @Bean
    public LdapTemplate ldapTemplate(LdapProperties properties, MutablePooledContextSource contextSource) {
        LdapProperties.Template template = properties.getTemplate();
        PropertyMapper propertyMapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        LdapTemplate ldapTemplate = new LdapTemplate(contextSource);
        propertyMapper.from(template.isIgnorePartialResultException())
                .to(ldapTemplate::setIgnorePartialResultException);
        propertyMapper.from(template.isIgnoreNameNotFoundException()).to(ldapTemplate::setIgnoreNameNotFoundException);
        propertyMapper.from(template.isIgnoreSizeLimitExceededException())
                .to(ldapTemplate::setIgnoreSizeLimitExceededException);
        return ldapTemplate;
    }

}
