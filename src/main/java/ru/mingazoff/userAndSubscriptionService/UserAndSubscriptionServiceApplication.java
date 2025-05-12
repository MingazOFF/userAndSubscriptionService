package ru.mingazoff.userAndSubscriptionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAndSubscriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAndSubscriptionServiceApplication.class, args);
        System.out.println("http://localhost:8088/swagger-ui/index.html");
    }

}
