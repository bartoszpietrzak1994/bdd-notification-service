package com.bargain.notifications.notification.sender.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsGateway {

    public void send(String text, String phoneNumber) {
        log.info("Sending message {} to phoneNumber {}", text, phoneNumber);
    }
}
