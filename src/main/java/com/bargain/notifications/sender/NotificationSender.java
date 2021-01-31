package com.bargain.notifications.sender;

import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.model.NotificationReceiver;

public interface NotificationSender {

    NotificationChannel getChannel();
    void send(String message, NotificationReceiver to);
}
