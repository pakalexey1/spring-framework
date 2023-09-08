package beanPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class AnotherConfig {

    @Bean
    public String str1() {
        return "Welcome to the app";
    }

    @Bean
    public String str2() {
        return "Spring Core Practice";
    }
}
