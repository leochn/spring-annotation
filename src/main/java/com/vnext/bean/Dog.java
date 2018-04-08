package com.vnext.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author leo
 * @version 2018/4/7 7:01
 * @since 1.0.0
 */
@Component
public class Dog {
    public Dog(){
        System.out.println("dog constructor...");
    }

    //PostConstruct注解,对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("Dog....@PostConstruct...");
    }

    //PreDestroy注解,容器移除对象之前
    @PreDestroy
    public void detory(){
        System.out.println("Dog....@PreDestroy...");
    }
}
