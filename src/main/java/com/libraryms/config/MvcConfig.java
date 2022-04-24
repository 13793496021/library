package com.libraryms.config;

import com.libraryms.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//设置允许跨域的路径
                .allowedOrigins("http://127.0.0.1:8080")//允许指定前端的请求跨域，穿cookie不能*
                .allowedHeaders("*")//允许的请求头
                .allowedMethods("*")//允许请求的方法：get、post、put....
                .allowCredentials(true)//使用凭证
                .maxAge(3600);//允许跨域时间
    }

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login/**","/api/sign/**","/api/forgetPassword/**");
    }

}
