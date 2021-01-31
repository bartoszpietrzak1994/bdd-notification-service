package com.bargain.notifications.sender;

import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.gateway.EmailGateway;
import com.bargain.notifications.model.NotificationReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationSender implements NotificationSender {

    @Autowired
    private EmailGateway emailGateway;

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }

    @Override
    public void send(String message, NotificationReceiver to) {
        emailGateway.send(message, to.getEmail());
    }
}
