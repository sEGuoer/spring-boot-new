package com.seguoer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(MyProperties.class)
@Configuration
public class MyConfig {
}
