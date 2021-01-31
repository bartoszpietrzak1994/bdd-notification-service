package com.bargain.notifications.controller;

import com.bargain.notifications.NotificationServiceApp;
import com.bargain.notifications.converter.ChannelConverter;
import com.bargain.notifications.dto.ChannelDto;
import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.dto.request.CreateChannelRequest;
import com.bargain.notifications.model.Channel;
import com.bargain.notifications.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping(ChannelController.PATH)
public class ChannelController {

    public static final String PATH = NotificationServiceApp.VI_API_PREFIX + "/channel";

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelConverter channelConverter;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ChannelDto create(@Valid @RequestBody CreateChannelRequest createChannelRequest) {
        Channel channel = channelService.createChannel(createChannelRequest);
        return channelConverter.toDto(channel);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/{channelType}/enable", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ChannelDto enable(@PathVariable String channelType) {
        Channel channel = channelService.enableChannel(NotificationChannel.valueOf(channelType));
        return channelConverter.toDto(channel);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/{channelType}/disable", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    public ChannelDto disable(@PathVariable String channelType) {
        Channel channel = channelService.disableChannel(NotificationChannel.valueOf(channelType));
        return channelConverter.toDto(channel);
    }
}
