package com.bargain.notifications.notification.sender;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notifications.notification.sender.gateway.SmsGateway;
import com.bargain.notifications.notification.receiver.NotificationReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationSender implements NotificationSender {

    @Autowired
    private SmsGateway smsGateway;

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.SMS;
    }

    @Override
    public void send(String message, NotificationReceiver to) {
        smsGateway.send(message, to.getPhoneNumber());
    }
}
