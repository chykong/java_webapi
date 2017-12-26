package com.balance.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 校验登录拦截器配置
 *
 * @author 孔垂云
 */
@Configuration
public class LogConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //校验是否登录拦截器
        registry.addInterceptor(new LogInterceptor())
                //消息相关
                .addPathPatterns("/news/*")
                .addPathPatterns("/checkLogin");
        super.addInterceptors(registry);
    }
}
