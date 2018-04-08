package com.vnext.config;

import com.vnext.bean.Person;
import com.vnext.filter.MyTypeFilter;
import org.springframework.context.annotation.*;

/**
 * 组件注册：ComponentScan，自动扫描包
 * @author leo
 * @version 2018/4/3 18:17
 * @since 1.0.0
 */
@Configuration

//@ComponentScan(value="com.vnext")

//@ComponentScan(value="com.vnext",excludeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class})
//})


//@ComponentScan(value="com.vnext",includeFilters = {
//        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Service.class})
//},useDefaultFilters = false)

//@ComponentScans(value = {
//        @ComponentScan(value="com.vnext",excludeFilters = {
//                @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class}),
//                @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
//        })
//})

@ComponentScans(value = {
        @ComponentScan(value="com.vnext",excludeFilters = {
                @ComponentScan.Filter(type= FilterType.CUSTOM,classes = {MyTypeFilter.class})
        })
})

public class MainConfig02 {

    //@ComponentScan  value:指定要扫描的包
    //excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
    //includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件,但是需要指定 useDefaultFilters = false
    //FilterType.ANNOTATION：按照注解
    //FilterType.ASSIGNABLE_TYPE：按照给定的类型；
    //FilterType.ASPECTJ：使用ASPECTJ表达式
    //FilterType.REGEX：使用正则指定
    //FilterType.CUSTOM：使用自定义规则


    @Bean("person")
    public Person person01(){
        return new Person("lisi", 20);
    }
}
