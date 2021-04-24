package com.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@Import(com.demo.Jwt.config.SwaggerConfiguration.class)
public class LatticeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatticeAssignmentApplication.class, args);
	}
//	@Bean
//	public Docket swaggerConfig() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
////				.paths(PathSelectors.ant("/patients/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.demo"))
//				.build()
//				.apiInfo(apiDetails());
//	}
//	private ApiInfo apiDetails() {
//		return new ApiInfo
//				("Lattice Solution Assignment", 
//				"Sample API for Patient Details",
//					"4.5",
//					"Free to use",
//					new springfox.documentation.service.Contact("Vivek", "viveksingh2121@gmail.com", "viveksingh2121@gmail.com"), 
//					"API Locense", 
//					"www.google.com",
//					Collections.emptyList());
//					
//				
//	}
//	

}
