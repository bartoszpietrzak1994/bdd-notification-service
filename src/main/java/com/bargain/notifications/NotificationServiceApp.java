package com.bargain.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApp {

    public static final String VI_API_PREFIX = "/api/v1";

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApp.class, args);
    }
}
