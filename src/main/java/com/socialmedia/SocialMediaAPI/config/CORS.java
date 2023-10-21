package com.socialmedia.SocialMediaAPI.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CORS implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Cho phép yêu cầu từ nguồn này
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép phương thức nào
                .allowedHeaders("Content-Type") // Cho phép các tiêu đề
                .allowCredentials(true); // Cho phép chia sẻ cookie giữa các tên miền khác nhau
    }
}
