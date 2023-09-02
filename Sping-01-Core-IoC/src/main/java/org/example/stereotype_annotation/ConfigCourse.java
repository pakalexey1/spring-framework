package org.example.stereotype_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = "org.example")
public class ConfigCourse {
}
