package com.bargain.notifications.controller;

import com.bargain.notification.client.ChannelController;
import com.bargain.notification.client.dto.ChannelDto;
import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notification.client.dto.request.CreateChannelRequest;
import com.bargain.notifications.NotificationServiceApp;
import com.bargain.notifications.converter.ChannelConverter;
import com.bargain.notifications.model.Channel;
import com.bargain.notifications.service.ChannelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@Slf4j
public class ChannelControllerImpl implements ChannelController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/channel";

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelConverter channelConverter;

    @Override
    public ChannelDto create(@Valid @RequestBody CreateChannelRequest createChannelRequest) {
        log.info("About to create a notification channel {}", createChannelRequest.getNotificationChannel().name());

        Channel channel = channelService.createChannel(createChannelRequest);
        return channelConverter.toDto(channel);
    }

    @Override
    public ChannelDto enable(@PathVariable String channelType) {
        log.info("About to enable notification channel {}", channelType);

        Channel channel = channelService.enableChannel(NotificationChannel.valueOf(channelType));
        return channelConverter.toDto(channel);
    }

    @Override
    public ChannelDto disable(@PathVariable String channelType) {
        log.info("About to disable notification channel {}", channelType);

        Channel channel = channelService.disableChannel(NotificationChannel.valueOf(channelType));
        return channelConverter.toDto(channel);
    }
}
