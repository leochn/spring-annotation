package com.vnext.test;

import com.vnext.bean.OrgUser;
import com.vnext.config.MainConfig06PropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author leo
 * @version 2018/4/7 7:26
 * @since 1.0.0
 */
public class IOCTest03PropertyValue {


    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfig06PropertyValues.class);

    @Test
    public void test01(){
        printBeans(applicationContext);
        System.out.println("=============");

        OrgUser orgUser = (OrgUser) applicationContext.getBean("orgUser");
        System.out.println(orgUser);


        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("orgUser.nickName");
        System.out.println(property);
        applicationContext.close();
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
