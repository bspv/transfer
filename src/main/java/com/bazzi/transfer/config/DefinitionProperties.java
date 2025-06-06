package com.bazzi.transfer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "definition")
public class DefinitionProperties {

    @Value("${spring.cache.redis.key-prefix}")
    private String cachePrefix;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${webclient.baseUrl}")
    private String baseUrl;
    @Value("${webclient.timeoutSeconds}")
    private Integer timeoutSeconds;

}
