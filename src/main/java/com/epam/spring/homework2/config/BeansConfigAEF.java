package com.epam.spring.homework2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.homework2.bean")
@Import(BeansConfigBDC.class)
public class BeansConfigAEF {}
