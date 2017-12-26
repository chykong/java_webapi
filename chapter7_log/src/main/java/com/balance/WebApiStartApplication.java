package com.balance;

import com.balance.util.spring.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by 孔垂云 on 2017/12/23.
 */
@SpringBootApplication
public class WebApiStartApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(WebApiStartApplication.class, args);
        SpringContextUtil.setApplicationContext(applicationContext);
    }
}
