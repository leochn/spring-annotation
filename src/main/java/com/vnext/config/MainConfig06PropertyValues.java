package com.vnext.config;

import com.vnext.bean.OrgUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 属性赋值
 * @author leo
 * @version 2018/4/7 7:24
 * @since 1.0.0
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/orgUser.properties"})
@Configuration
public class MainConfig06PropertyValues {

    @Bean
    public OrgUser orgUser(){
        return new OrgUser();
    }
}
