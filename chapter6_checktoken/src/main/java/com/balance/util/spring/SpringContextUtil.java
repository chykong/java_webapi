/*
* Copyright 2017 tuola Croporation Limited. All rights reserved.
*
*/
package com.balance.util.spring;

import org.springframework.context.ApplicationContext;

/**
 * 上下文获取工具类
 *
 * @author 孔垂云 on 2017/8/18.
 */
public class SpringContextUtil {
    /**
     * 上下文对象
     */
    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    /**
     *
     * @param beanId bean的id
     * @return 该类的实例
     */
    public static Object getBean(String beanId) {
        return applicationContext.getBean(beanId);
    }
}
