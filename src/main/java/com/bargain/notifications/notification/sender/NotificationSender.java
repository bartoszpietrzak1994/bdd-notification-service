package com.bargain.notifications.notification.sender;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notifications.notification.receiver.NotificationReceiver;

public interface NotificationSender {

    NotificationChannel getChannel();
    void send(String message, NotificationReceiver to);
}
