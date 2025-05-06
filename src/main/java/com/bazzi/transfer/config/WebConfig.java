package com.bazzi.transfer.config;

import com.bazzi.transfer.interceptor.CustomInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebConfig implements WebMvcConfigurer {

    private final CustomInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/static/**",
                        "/v2/api-docs-ext",
                        "/webjars/**",
                        "/swagger-resources",
                        "/swagger-resources/configuration/ui",
                        "/**.html");
    }

    /**
     * 跨域配置
     *
     * @param registry registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 所有接口
                .allowedOrigins("*")// 允许的源
                .allowedMethods("*")// 允许的方法，或"GET", "POST", "PUT", "DELETE", "OPTIONS"
                .allowedHeaders("*")// 允许的请求头
                .allowCredentials(true)// 允许发送 Cookie
                .maxAge(3600)// 预检请求的缓存时间（秒）
                .exposedHeaders(HttpHeaders.SET_COOKIE);
    }
}
