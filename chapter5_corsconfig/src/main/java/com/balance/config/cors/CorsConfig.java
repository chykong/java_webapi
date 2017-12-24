/*
* Copyright 2017 tuola Croporation Limited. All rights reserved.
*
*/
package com.balance.config.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * SpringBoot 处理跨域请求
 *
 * @author 孔垂云 on 2017/9/14.
 */
@Configuration
public class CorsConfig {
    /**
     * 配置跨越的参数
     *
     * @return 配置信息
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3所有请求方法
        return corsConfiguration;
    }

    /**
     * 加入过滤器
     *
     * @return 过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}