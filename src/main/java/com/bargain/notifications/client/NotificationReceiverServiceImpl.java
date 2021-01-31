package com.bargain.notifications.client;

import com.bargain.notifications.model.NotificationReceiver;
import com.bargain.notifications.repository.NotificationReceiverRepository;
import com.bargain.notifications.service.NotificationReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationReceiverServiceImpl implements NotificationReceiverService {

    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    @Override
    public NotificationReceiver create(NotificationReceiver notificationReceiver) {
        return notificationReceiverRepository.save(notificationReceiver);
    }

    @Override
    public NotificationReceiver update(NotificationReceiver notificationReceiver) {
        NotificationReceiver existingNotificationReceiver = notificationReceiverRepository
                .getOneByUserReference(notificationReceiver.getUserReference());

        existingNotificationReceiver.setEmail(notificationReceiver.getEmail());
        existingNotificationReceiver.setPhoneNumber(notificationReceiver.getPhoneNumber());
        existingNotificationReceiver.setNotificationChannels(notificationReceiver.getNotificationChannels());

        return notificationReceiverRepository.save(existingNotificationReceiver);
    }
}
