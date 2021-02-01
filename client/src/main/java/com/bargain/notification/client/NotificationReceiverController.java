package com.bargain.notification.client;

import com.bargain.notification.Constants;
import com.bargain.notification.client.dto.NotificationReceiverDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(NotificationReceiverController.PATH)
public interface NotificationReceiverController {

    String PATH = Constants.VI_API_PREFIX + "/receiver";

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    NotificationReceiverDto create(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto);

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    NotificationReceiverDto update(@Valid @RequestBody NotificationReceiverDto notificationReceiverDto);
}
