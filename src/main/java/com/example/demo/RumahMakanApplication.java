package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;



@SpringBootApplication
@EnableSwagger2WebMvc
public class RumahMakanApplication {

	public static void main(String[] args) {
		SpringApplication.run(RumahMakanApplication.class, args);
	}
	@Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controlle"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiDetails());
    }
	
	private ApiInfo apiDetails() {
      return new ApiInfo(
              "Apps RumahMakan",
              "Api Documentation",
              "1.0",
              "",
              new springfox.documentation.service.Contact("Rasyid", "", "rasyidmaulidmajid@gmail.com"),
              "",
              "",
              Collections.emptyList());
  }


}
