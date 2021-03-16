package com.bargain.notifications.controller;

import com.bargain.notification.client.NotificationReceiverController;
import com.bargain.notification.client.dto.NotificationReceiverDto;
import com.bargain.notifications.converter.NotificationReceiverConverter;
import com.bargain.notifications.model.NotificationReceiver;
import com.bargain.notifications.service.NotificationReceiverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(NotificationReceiverControllerImpl.PATH)
@Slf4j
public class NotificationReceiverControllerImpl implements NotificationReceiverController {

    @Autowired
    private NotificationReceiverConverter notificationReceiverConverter;

    @Autowired
    private NotificationReceiverService notificationReceiverService;

    @Override
    public NotificationReceiverDto create(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto) {
        log.info("About to create a notification receiver with reference {}", notificationReceiverDto.getUserReference());

        NotificationReceiver notificationReceiver = notificationReceiverConverter.toModel(notificationReceiverDto);
        return notificationReceiverConverter.toDto(notificationReceiverService.create(notificationReceiver));
    }

    @Override
    public NotificationReceiverDto update(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto) {
        log.info("About to update a notification receiver with reference {}", notificationReceiverDto.getUserReference());

        NotificationReceiver notificationReceiver = notificationReceiverConverter.toModel(notificationReceiverDto);
        return notificationReceiverConverter.toDto(notificationReceiverService.update(notificationReceiver));
    }
}
