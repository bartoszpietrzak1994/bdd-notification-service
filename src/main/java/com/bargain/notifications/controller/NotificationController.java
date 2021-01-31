package com.bargain.notifications.controller;

import com.bargain.notifications.NotificationServiceApp;
import com.bargain.notifications.dto.request.SendNotificationRequest;
import com.bargain.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(NotificationController.PATH)
public class NotificationController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/notification";

    @Autowired
    private NotificationService notificationService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void send(@Valid @RequestBody SendNotificationRequest sendNotificationRequest) {
        notificationService.send(sendNotificationRequest.getMessage(), sendNotificationRequest.getUserReference());
    }
}
