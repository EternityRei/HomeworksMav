package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class BeanD {
    private String name;
    private String value;

    @Autowired
    public BeanD(@Value("${data.bean.name}")String name, @Value("${data.bean.value}")String value) {
        this.name = name;
        this.value = value;
    }

    public void init(){
        System.out.println("BeanD init method");
    }

    public void destroy(){
        System.out.println("BeanD destroy method");
    }
    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}