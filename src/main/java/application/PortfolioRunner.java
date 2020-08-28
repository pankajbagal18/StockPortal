package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioRunner {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioRunner.class,args);
        System.out.println("Hello Spring");
    }
}
