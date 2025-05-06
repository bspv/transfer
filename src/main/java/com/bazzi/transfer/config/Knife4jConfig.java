package com.bazzi.transfer.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableOpenApi
@EnableKnife4j
public class Knife4jConfig {

    @Resource
    private DefinitionProperties definitionProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30) // 使用 OAS_30 文档类型
                .enable(!StringUtils.equals("prod", definitionProperties.getActiveProfile())) // 生产环境禁用
                .apiInfo(apiInfo())
                .globalRequestParameters(buildGlobalRequestParameters())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bazzi.transfer.controller"))
                .paths(PathSelectors.any())
                .build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Transfer API")
                .description("Transfer接口文档")
                .version("1.0")
                .build();
    }

    private List<RequestParameter> buildGlobalRequestParameters() {
        List<RequestParameter> list = new ArrayList<>();
        list.add(new RequestParameterBuilder()
                .name("SERIAL-NUMBER")
                .description("请求流水号")
                .in(ParameterType.HEADER)
                .required(true)
                .build());
        return list;
    }
}