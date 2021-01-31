package com.bargain.notifications.service;

import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.dto.request.CreateChannelRequest;
import com.bargain.notifications.model.Channel;

import java.util.List;

public interface ChannelService {

    Channel createChannel(CreateChannelRequest createChannelRequest);

    Channel enableChannel(NotificationChannel notificationChannel);

    Channel disableChannel(NotificationChannel notificationChannel);

    List<Channel> getSupportedChannels();
}
