package stereotype_annotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "stereotype_annotations") //to make it scan outside the current package only ("config" package)
public class AppConfig {
}
