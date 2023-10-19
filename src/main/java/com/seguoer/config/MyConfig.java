package com.seguoer.config;

import com.seguoer.po.Person;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({MyProperties.class, Person.class})
@Configuration
public class MyConfig {
}
