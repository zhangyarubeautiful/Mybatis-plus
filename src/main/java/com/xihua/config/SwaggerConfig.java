package com.xihua.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.xihua.constant.HeaderConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger config
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    /**
     * Create rest api docket
     *
     * @return the docket
     */
    @Bean
    public Docket createRestApi(){

        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        Parameter paramBuild = tokenParam.name(HeaderConstants.AUTHORIZATION).description("请求头信息").modelRef(new ModelRef("String"))
                .parameterType("header").required(true).build();
        parameterList.add(paramBuild);

        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xihua.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIS")
                .description("API接口文档")
                .contact(new Contact("developer","",""))
                .termsOfServiceUrl("http://127.0.0.1:8080")
                .version("1.0")
                .build();
    }
}
