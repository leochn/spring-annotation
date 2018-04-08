package com.vnext.test;

import com.vnext.bean.Yellow;
import com.vnext.config.MainConfig08Profile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author leo
 * @version 2018/4/9 6:18
 * @since 1.0.0
 */
public class IOCTest05Profile {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；

    @Test
    public void test01(){

        // 加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig08Profile.class);

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();
    }


    @Test
    public void test02(){
        // 代码的方式激活某种环境
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();

        //1、创建一个applicationContext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("prod");
        //3、注册主配置类
        applicationContext.register(MainConfig08Profile.class);
        //4、启动刷新容器
        applicationContext.refresh();


        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String string : namesForType) {
            System.out.println(string);
        }

        Yellow bean = applicationContext.getBean(Yellow.class);
        System.out.println(bean);
        applicationContext.close();
    }
}
