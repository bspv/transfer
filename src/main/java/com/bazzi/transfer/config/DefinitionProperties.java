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

//    @Value("${webclient.baseUrl}")
    @Value("${spring.ai.deepseek.base-url}")
    private String baseUrl;
    @Value("${spring.ai.deepseek.api-key}")
    private String apiKey;
    @Value("${spring.ai.deepseek.timeout-seconds}")
    private Integer timeoutSeconds;

    public boolean isProduction() {
        return "prod".equals(activeProfile);
    }
}
