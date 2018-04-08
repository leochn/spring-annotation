package com.vnext.test;

import com.vnext.bean.Person;
import com.vnext.config.MainConfig01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leo
 * @version 2018/4/4 6:46
 * @since 1.0.0
 */
public class MainTest {

    //@SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig01.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

}
