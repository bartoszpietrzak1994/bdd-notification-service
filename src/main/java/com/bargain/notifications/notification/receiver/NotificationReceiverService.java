package com.bargain.notifications.notification.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationReceiverService {

    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    public NotificationReceiver create(NotificationReceiver notificationReceiver) {
        return notificationReceiverRepository.save(notificationReceiver);
    }

    public NotificationReceiver update(NotificationReceiver notificationReceiver) {
        NotificationReceiver existingNotificationReceiver = notificationReceiverRepository
                .getOneByUserReference(notificationReceiver.getUserReference());

        existingNotificationReceiver.setEmail(notificationReceiver.getEmail());
        existingNotificationReceiver.setPhoneNumber(notificationReceiver.getPhoneNumber());
        existingNotificationReceiver.setNotificationChannels(notificationReceiver.getNotificationChannels());

        return notificationReceiverRepository.save(existingNotificationReceiver);
    }
}
