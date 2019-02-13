package com.connectivity.vikray;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
	com.connectivity.vikray.pojo.FileStorageProperties.class
})
@EntityScan(basePackageClasses = { 
		JpaApplication.class,
		Jsr310JpaConverters.class 
})
public class JpaApplication {


		@PostConstruct
		void init() {
			TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		}
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}

