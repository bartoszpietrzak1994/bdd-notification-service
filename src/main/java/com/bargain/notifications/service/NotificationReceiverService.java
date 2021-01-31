package com.bargain.notifications.service;

import com.bargain.notifications.model.NotificationReceiver;

public interface NotificationReceiverService {

    NotificationReceiver create(NotificationReceiver notificationReceiver);

    NotificationReceiver update(NotificationReceiver notificationReceiver);
}
