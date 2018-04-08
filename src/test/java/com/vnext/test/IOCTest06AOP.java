package com.vnext.test;

import com.vnext.aop.MathCalculator;
import com.vnext.config.MainConfig09AOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leo
 * @version 2018/4/9 6:40
 * @since 1.0.0
 */
public class IOCTest06AOP {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig09AOP.class);

        //1、不要自己创建对象
//		MathCalculator mathCalculator = new MathCalculator();
//		mathCalculator.div(1, 1);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

        mathCalculator.div(1, 1);

        System.out.println("===================================");

        mathCalculator.div(1, 0);

        applicationContext.close();
    }
}
