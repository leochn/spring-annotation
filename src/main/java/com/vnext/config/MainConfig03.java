package com.vnext.config;

import com.vnext.bean.Person;
import com.vnext.bean.Student;
import com.vnext.condition.LinuxCondition;
import com.vnext.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * 组件注册：Scope， 组件作用域
 * @author leo
 * @version 2018/4/5 9:58
 * @since 1.0.0
 */
//类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效；
//@Conditional({WindowsCondition.class})
@Configuration
public class MainConfig03 {


    // Scope:默认是单实例的
     /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
     *
     * Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中,每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中,以后每次获取就是直接从容器[map.get()]中拿，
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     *
     */

    @Bean("person")
    public Person person(){
        System.out.println("singleton,给容器中添加Person....");
        return new Person("张三", 25);
    }

    @Scope("prototype")
    @Bean("student")
    public Student student(){
        System.out.println("prototype,给容器中添加 Student....");
        return new Student("小明",15);
    }

    @Lazy
    @Bean("person1")
    public Person person1(){
        System.out.println("Lazy,给容器中添加Person....");
        return new Person("person1", 25);
    }

    /**
     * Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 48);
    }


}
