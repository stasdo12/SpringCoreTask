package com.donec.spring_core_task.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.donec.spring_core_task")
@PropertySource("classpath:application.properties")
public class GymAppConfig {
}
