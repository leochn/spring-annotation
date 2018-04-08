package com.vnext.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author leo
 * @version 2018/4/7 7:45
 * @since 1.0.0
 */
public class OrgUser {

    //使用@Value赋值；
    //1、基本数值
    //2、可以写SpEL； #{}
    //3、可以写${}；取出配置文件【properties】中的值（在运行环境变量里面的值）


    @Value("#{20-2}")
    private Integer age;

    @Value("张悦")
    private String name;

    @Value("${orgUser.nickName}")
    private String nickName;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public OrgUser() {
    }

    @Override
    public String toString() {
        return "OrgUser{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
