package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    Filter filter;

    @Autowired
    Filterindex filterindex;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(filter).addPathPatterns("/home");
        registry.addInterceptor(filterindex).addPathPatterns("/");
    }
}
