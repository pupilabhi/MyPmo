package com.connectivity.vikray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.connectivity.vikray.config.AuditorAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EntityScan(basePackageClasses = { 
		JpaApplication.class,
		Jsr310JpaConverters.class 
})
public class JpaApplication {

	 @Bean
	    public AuditorAware<String> auditorAware() {
	        return new AuditorAwareImpl();
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}

