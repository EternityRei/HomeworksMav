package com.epam.spring.homework2.config;

import com.epam.spring.homework2.bean.BeanB;
import com.epam.spring.homework2.bean.BeanC;
import com.epam.spring.homework2.bean.BeanD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"com.epam.spring.homework2.bean", "com.epam.spring.homework2.processor"})
@PropertySource("classpath:app.properties")
public class BeansConfigBDC {

    @Value("data.bean.name")
    private String name;

    @Value("data.bean.value")
    private String value;

    @Bean(name = "beanB", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanD")
    public BeanB beanB(){
        return new BeanB(name, value);
    }

    @Bean(name = "beanB", initMethod = "init", destroyMethod = "destroy")
    @DependsOn("beanB")
    public BeanC beanC(){
        return new BeanC(name, value);
    }

    @Bean(name = "beanD", initMethod = "init", destroyMethod = "destroy")
    public BeanD beanD(){
        return new BeanD(name, value);
    }
}
