package org.example.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Interceptor interceptor;

    List<String> excludePath = Arrays.asList(
            "/css/**","/js/**","/pic/**","/book/login","/**/login.html"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
