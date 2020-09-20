package br.com.tinnova.desafio.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
		.apis(RequestHandlerSelectors.basePackage("br.com.tinnova.desafio.controller"))
		.build()
		.apiInfo(metadata());
	}
	
	private ApiInfo metadata() {
		return new ApiInfoBuilder().
				title("API de veiculos")
				.description("Uma API simples utilizando spring boot")
				.contact(new Contact("Romario", "romario.bsp.silva@gmail.com", null))
				.build();
	}
}