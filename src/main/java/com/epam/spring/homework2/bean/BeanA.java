package com.epam.spring.homework2.bean;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean {
    private String name;
    private String value;

    @Autowired
    public BeanA(@Value("${data.bean.name}")String name,@Value("${data.bean.value}") String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA destroying through override method " +
                "destroy from " + DisposableBean.class.getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA initializing through override method " +
                "afterPropertiesSet from " + InitializingBean.class.getSimpleName());
    }
}