package com.api.data_visualization_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class DataVisualizationDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataVisualizationDashboardApplication.class, args);
	}

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
			public void addCorsMappings( CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000")
				.allowedMethods("GET");
            }
        };
    }

}
