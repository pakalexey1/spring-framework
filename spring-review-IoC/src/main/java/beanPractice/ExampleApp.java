package beanPractice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExampleApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class,AnotherConfig.class);

        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();

        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();

        String str1 = container.getBean("str1",String.class); //the default bean names are str1 and str2
        System.out.println(str1);
    }
}
