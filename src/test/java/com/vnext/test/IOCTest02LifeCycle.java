package com.vnext.test;

import com.vnext.config.MainConfig05LifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leo
 * @version 2018/4/6 19:25
 * @since 1.0.0
 */
public class IOCTest02LifeCycle {

    @Test
    public void test01(){
        //1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig05LifeCycle.class);
        System.out.println("容器创建完成...");

        //applicationContext.getBean("car");
        //关闭容器
        applicationContext.close();
    }
}
