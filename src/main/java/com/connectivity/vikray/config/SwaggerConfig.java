package com.connectivity.vikray.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
		      "Abhishek Aradhya", "http://www.pmo.vikray.io", "vikray@connectivitysolutions.in");
		  
		  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
		      "Awesome API Title", "Awesome API Description", "1.0",
		      "urn:tos", DEFAULT_CONTACT, 
		      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

		  private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json",
		          "application/xml"));

		  @Bean
		  public Docket api() {
		    return new Docket(DocumentationType.SWAGGER_2)
		        .apiInfo(DEFAULT_API_INFO)
		        .produces(DEFAULT_PRODUCES_AND_CONSUMES)
		        .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
		  }

	/*@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(paths())
                .build();
    }

    // Describe your apis
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Sample APIs")
                .description("This page lists all the rest apis for Swagger Sample App.")
                .version("1.0-SNAPSHOT")
                .build();
    }

 // Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
    	// Match all paths except /error
        return Predicates.and(
        	PathSelectors.regex("/pmo.*"), 
        	Predicates.not(PathSelectors.regex("/error.*"))
        );
    }*/
}
