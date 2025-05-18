package com.bazzi.transfer.config;

import com.bazzi.transfer.interceptor.CustomInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WebConfig implements WebMvcConfigurer {

    private final CustomInterceptor commonInterceptor;
    private final DefinitionProperties definitionProperties;


    public static ExchangeFilterFunction logRequestResponse() {
        return ExchangeFilterFunction.ofRequestProcessor(request -> {
            log.info("Request: {} {}", request.method(), request.url());
            log.info("Headers: {}", request.headers());
            log.info("Body: {}", request.body());
            return Mono.just(request);
        }).andThen(ExchangeFilterFunction.ofResponseProcessor(response -> {
            log.info("Response Status: {}", response.statusCode());
            return response.bodyToMono(String.class)
                    .doOnNext(body -> log.info("Response Body: {}", body))
                    .thenReturn(response);
        }));
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(definitionProperties.getBaseUrl())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().responseTimeout(
                                Duration.ofSeconds(definitionProperties.getTimeoutSeconds())) // 响应超时
                ))
                .filter(logRequestResponse()) // 添加日志过滤器
                .build();
    }

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
