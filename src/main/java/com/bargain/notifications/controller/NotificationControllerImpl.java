package com.bargain.notifications.controller;

import com.bargain.notification.client.NotificationController;
import com.bargain.notification.client.dto.request.SendNotificationRequest;
import com.bargain.notifications.NotificationServiceApp;
import com.bargain.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class NotificationControllerImpl implements NotificationController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/notification";

    @Autowired
    private NotificationService notificationService;

    @Override
    public void send(@Valid @RequestBody SendNotificationRequest sendNotificationRequest) {
        notificationService.send(sendNotificationRequest.getMessage(), sendNotificationRequest.getUserReference());
    }
}
