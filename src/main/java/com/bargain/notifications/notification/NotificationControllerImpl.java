package com.bargain.notifications.notification;

import com.bargain.notification.client.NotificationController;
import com.bargain.notification.client.dto.request.SendNotificationRequest;
import com.bargain.notifications.NotificationServiceApp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@Slf4j
public class NotificationControllerImpl implements NotificationController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/notification";

    @Autowired
    private NotificationService notificationService;

    @Override
    public void send(@Valid @RequestBody SendNotificationRequest sendNotificationRequest) {
        log.info("About to send a notification to user {}", sendNotificationRequest.getUserReference());
        notificationService.send(sendNotificationRequest.getMessage(), sendNotificationRequest.getUserReference());
    }
}
