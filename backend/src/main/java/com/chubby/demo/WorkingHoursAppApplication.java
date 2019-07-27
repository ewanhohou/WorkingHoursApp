package com.chubby.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@MapperScan("com.chubby.demo")
@SpringBootApplication
public class WorkingHoursAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkingHoursAppApplication.class, args);
    }

    // Enable CORS globally
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/*").allowedOrigins("http://192.168.1.10:8080");
            }
        };
    }
}
