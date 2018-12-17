package com.netcracker.travel.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket swaggerSettings() {
    List<SecurityScheme> schemeList = new ArrayList<>();
    schemeList.add(new BasicAuth("basicAuth"));
    return new Docket(DocumentationType.SWAGGER_2)
            .securitySchemes(schemeList)
            .directModelSubstitute(LocalTime.class, Long.class)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(Predicates.not(PathSelectors.regex("/error.*")))
            .paths(PathSelectors.any())

            .build();
//    return new Docket(DocumentationType.SWAGGER_2)
//        .select()
//        .apis(RequestHandlerSelectors.basePackage("com.netcracker.travel.controller"))
//        .build();
  }


}