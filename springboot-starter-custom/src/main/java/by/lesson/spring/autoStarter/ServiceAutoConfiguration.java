package by.lesson.spring.autoStarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfiguration {
    @Bean
    String demoBean(){
        return "Hello Starter";
    }
}
