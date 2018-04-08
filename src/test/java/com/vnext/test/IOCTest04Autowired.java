package com.vnext.test;

import com.vnext.bean.Boss;
import com.vnext.bean.Car;
import com.vnext.bean.Color;
import com.vnext.config.MainConfig07Autowired;
import com.vnext.dao.BookDao;
import com.vnext.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author leo
 * @version 2018/4/7 10:23
 * @since 1.0.0
 */
public class IOCTest04Autowired {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig07Autowired.class);

        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

        BookDao bean = applicationContext.getBean(BookDao.class);
        System.out.println(bean);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        System.out.println(applicationContext);
        applicationContext.close();
    }
}
