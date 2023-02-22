package com.hudingwen.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ClassName:Person
 * Package:com.hudingwen.springboot
 * Description:获取配置信息-第三种
 * Date:2022-10-20 11:18:44
 * Author:胡丁文
 * E-mail:admin@aiwanyun.cn
 **/
@Component
@ConfigurationProperties(prefix = "person")
public class PersonInfoConfig {
    private String name;
    private int age;
    private String[] address;

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
