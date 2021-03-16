package com.bargain.notifications.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailGateway {

    public static final String SUBJECT = "New event happened!";
    public static final String FROM = "<bargain-service@gmail.com>";

    @Autowired
    private JavaMailSender mailSender;

    public void send(String text, String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setSubject(SUBJECT);
        simpleMailMessage.setTo(email);
        simpleMailMessage.setText(text);

        mailSender.send(simpleMailMessage);
    }
}
