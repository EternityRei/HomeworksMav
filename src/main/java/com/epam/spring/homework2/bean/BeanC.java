package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class BeanC {
    private String name;
    private String value;

    @Autowired
    public BeanC(@Value("${data.bean.name}")String name, @Value("${data.bean.value}")String value) {
        this.name = name;
        this.value = value;
    }

    public void init(){
        System.out.println("BeanC init method");
    }

    public void destroy(){
        System.out.println("BeanC destroy method");
    }

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}