package com.connectivity.vikray.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()))
				.select().apis(RequestHandlerSelectors.any())
				.paths(paths()).build();
	}

	// Describe your apis
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Vikray-PMO  APIs")
				.description("This page lists all the rest apis for Vikray PMO App.").version("V1.0")
				.contact(new Contact("CSPL Software Team", "vikray.io", "vikray@connectivitysolutions.in")).build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext
				.builder()
				.securityReferences(defaultAuth())
				.forPaths(PathSelectors.any())
				.build();
	}

	private List<SecurityReference> defaultAuth() {
		 AuthorizationScope authorizationScope
         = new AuthorizationScope("global", "accessEverything");
     AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
     authorizationScopes[0] = authorizationScope;
     return Lists.newArrayList(
         new SecurityReference("JWT", authorizationScopes));
	}

	// Only select apis that matches the given Predicates.
	private Predicate<String> paths() {
		// Match all paths except /error
		return Predicates.and(PathSelectors.regex("/.*"), Predicates.not(PathSelectors.regex("/error.*")));
//				Predicates.not(PathSelectors.regex("/api/auth/.*"))); //
	}
}
