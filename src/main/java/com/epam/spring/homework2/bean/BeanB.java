package com.epam.spring.homework2.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BeanB {

    private String name;
    private String  value;

    @Autowired
    public BeanB(@Value("data.bean.name") String name, @Value("data.bean.value")String value) {
        this.name = name;
        this.value = value;
    }

    public void init(){
        System.out.println("BeanB init method");
    }

    public void newInitName(){
        System.out.println("BeanB newInitName method");
    }

    public void destroy(){
        System.out.println("BeanB destroy method");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
