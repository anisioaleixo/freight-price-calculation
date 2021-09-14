package br.com.anisioaleixo.freightpricecalculation.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.any())
	                .paths(PathSelectors.any())
	                .build()
	                .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfo(
				"RESTful API With Spring Boot 2.5.4", 
				"Some description about your API.",
				"v1",
				"Terms Of Service Url",
				new Contact("Anisio Aleixo", "https://github.com/anisioaleixo", "anisioaleixo@gmail.com"),
				"License of API", "License of URL", Collections.emptyList());
	}
}
