package com.vnext.bean;

import org.springframework.stereotype.Component;

/**
 * @author leo
 * @version 2018/4/6 19:27
 * @since 1.0.0
 */
@Component
public class Car {

    public Car(){
        System.out.println("car constructor...");
    }

    public void init(){
        System.out.println("car ... init...");
    }

    public void detory(){
        System.out.println("car ... detory...");
    }

}
