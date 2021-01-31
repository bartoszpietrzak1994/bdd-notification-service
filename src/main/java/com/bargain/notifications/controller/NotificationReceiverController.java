package com.bargain.notifications.controller;

import com.bargain.notifications.NotificationServiceApp;
import com.bargain.notifications.converter.NotificationReceiverConverter;
import com.bargain.notifications.dto.NotificationReceiverDto;
import com.bargain.notifications.model.NotificationReceiver;
import com.bargain.notifications.service.NotificationReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(NotificationReceiverController.PATH)
public class NotificationReceiverController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/receiver";

    @Autowired
    private NotificationReceiverConverter notificationReceiverConverter;

    @Autowired
    private NotificationReceiverService notificationReceiverService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public NotificationReceiverDto create(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto) {
        NotificationReceiver notificationReceiver = notificationReceiverConverter.toModel(notificationReceiverDto);
        return notificationReceiverConverter.toDto(notificationReceiverService.create(notificationReceiver));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public NotificationReceiverDto update(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto) {
        NotificationReceiver notificationReceiver = notificationReceiverConverter.toModel(notificationReceiverDto);
        return notificationReceiverConverter.toDto(notificationReceiverService.update(notificationReceiver));
    }
}
