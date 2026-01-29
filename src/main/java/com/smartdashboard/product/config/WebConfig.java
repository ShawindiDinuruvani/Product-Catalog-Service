package com.smartdashboard.product.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // බ්‍රවුසරයේ /uploads/ කියලා පටන් ගන්නා URL එකක් ආවොත්,
        // එය F:/uploads/ ෆෝල්ඩරයට යොමු කරන්න (Mapping)
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:F:/uploads/");
    }
}