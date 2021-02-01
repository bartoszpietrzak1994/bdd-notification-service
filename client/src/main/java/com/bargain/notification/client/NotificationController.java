package com.bargain.notification.client;

import com.bargain.notification.Constants;
import com.bargain.notification.client.dto.request.SendNotificationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@RequestMapping(NotificationController.PATH)
public interface NotificationController {

    String PATH = Constants.VI_API_PREFIX + "/notification";

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    void send(@Valid @RequestBody SendNotificationRequest sendNotificationRequest);
}
