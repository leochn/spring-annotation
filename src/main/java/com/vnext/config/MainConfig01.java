package com.vnext.config;

import com.vnext.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 组件注册：Configuration，配置类==配置文件
 * @author leo
 * @version 2018/4/3 17:56
 * @since 1.0.0
 */
@Configuration  //告诉Spring这是一个配置类
public class MainConfig01 {

    //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    @Bean("person")
    public Person person01(){
        return new Person("lisi", 20);
    }

}
