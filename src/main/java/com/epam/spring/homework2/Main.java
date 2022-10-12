package com.epam.spring.homework2;

import com.epam.spring.homework2.config.BeansConfigBDC;
import com.epam.spring.homework2.factory.PostProcessorFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        PostProcessorFactoryBean processor = new PostProcessorFactoryBean();

        context.register(BeansConfigBDC.class);
        context.addBeanFactoryPostProcessor(processor);
        context.refresh();

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(bean->System.out.println(context.getBeanDefinition(bean)));
        context.registerShutdownHook();
    }
}
