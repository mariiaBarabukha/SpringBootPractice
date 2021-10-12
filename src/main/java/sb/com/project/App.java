package sb.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sb.com.starter.ConsoleLogger;
import sb.com.starter.ILogger;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    ILogger logger;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.writeLog();
    }

    @Bean
    public ILogger iLogger(){
        return new ConsoleLogger();
    }
}