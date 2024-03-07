package com.rw.quickcare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.rw.quickcare.mapper")
public class QuickcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickcareApplication.class, args);
    }

    /**
     * 跨域配置
     */
//    @Bean
//    public CorsFilter corsFilter()
//    {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        // 是否允许请求带有验证信息
//        config.setAllowCredentials(true);
//
//        // 允许访问的客户端域名
//        // (springboot2.4以上的加入这一段可解决 allowedOrigins cannot contain the special value "*"问题)
//        List<String> allowedOriginPatterns = new ArrayList<>();
//        allowedOriginPatterns.add("*");
//        config.setAllowedOriginPatterns(allowedOriginPatterns);
//
//        // 设置访问源地址
//        // config.addAllowedOrigin("*");
//        // 设置访问源请求头
//        config.addAllowedHeader("*");
//        // 设置访问源请求方法
//        config.addAllowedMethod("*");
//        // 对接口配置跨域设置
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }

}
