package com.bargain.notifications.notification.sender;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notifications.notification.sender.gateway.EmailGateway;
import com.bargain.notifications.notification.receiver.NotificationReceiver;
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
