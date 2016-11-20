package com.skpcp.elista;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Tomek on 2016-03-16.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().paths(apiPaths()).build();
    }
    private com.google.common.base.Predicate<String> apiPaths() {
        return or(regex("/elista/.*"));
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("E-Lista").description("System Ewidencji").termsOfServiceUrl("Terms of Service")
                .contact("SK.PCP email: sk.pcp@wp.pl").license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE").version("2.0").build();
    }
}
