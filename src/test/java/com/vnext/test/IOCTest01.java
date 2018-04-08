package com.vnext.test;

import com.vnext.bean.Blue;
import com.vnext.bean.Person;
import com.vnext.config.MainConfig02;
import com.vnext.config.MainConfig03;
import com.vnext.config.MainConfig04;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 组件注册测试类
 * @author leo
 * @version 2018/4/4 7:08
 * @since 1.0.0
 */
public class IOCTest01 {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig03.class);
    AnnotationConfigApplicationContext context4 = new AnnotationConfigApplicationContext(MainConfig04.class);

    /**
     * 测试ComponentScan，自动扫描包
     */
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    /**
     * 测试Scope,singleton单实例
     */
    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig03.class);
        System.out.println("ioc容器创建完成....");
        Object bean = applicationContext.getBean("person");
        Object bean2 = applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    /**
     * 测试Scope,prototype多实例
     */
    @Test
    public void test03(){
        System.out.println("ioc容器创建完成....");
    }

    /**
     * 测试Scope,prototype多实例
     */
    @Test
    public void test04(){
        System.out.println("ioc容器创建完成....");
        Object bean = context.getBean("student");
        Object bean2 = context.getBean("student");
        System.out.println(bean == bean2);
    }


    /**
     * 测试Lazy,懒加载:容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化
     */
    @Test
    public void test05(){
        System.out.println("ioc容器创建完成....");
    }

    /**
     * 测试Lazy,懒加载:容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化
     */
    @Test
    public void test06(){
        System.out.println("ioc容器创建完成....");
        Object bean = context.getBean("person1");
    }

    /**
     * Conditional:按照一定的条件进行判断，满足条件给容器中注册bean
     */
    @Test
    public void test07(){
        String[] namesForType = context.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }

        Map<String, Person> persons = context.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test08Import(){
        printBeans(context4);

        Blue bean = context4.getBean(Blue.class);
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = context4.getBean("colorFactoryBean");
        Object bean3 = context4.getBean("colorFactoryBean");
        System.out.println("bean的类型："+bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = context4.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }

}
