package com.intuiture.qm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.intuiture.qm")
@ImportResource(value = { "classpath:rest_security.xml" })
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {

}