package com.epam.spring.homework2.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Objects;

public class PostProcessorBean implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("PostProcessorBean validation");
        if(!notNullNameOfBean(bean) && onlyPositiveValues(bean)){
            System.out.println("Bean " + beanName + " is valid");
            return bean;
        }
        else{
            throw new IllegalArgumentException("Bean " + beanName + " is not valid");
        }
    }

    public boolean notNullNameOfBean(Object bean){
        Field field = null;
        try {
            field = bean.getClass().getDeclaredField("name");
            String name = (String) field.get(bean);
            return Objects.isNull(name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean onlyPositiveValues(Object bean){
        Field field = null;
        try {
            field = bean.getClass().getDeclaredField("value");
            String value = (String) field.get(bean);
            return Integer.parseInt(value) > 0;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
