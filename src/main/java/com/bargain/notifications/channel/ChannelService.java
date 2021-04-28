package com.bargain.notifications.channel;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notification.client.dto.request.CreateChannelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public Channel create(CreateChannelRequest createChannelRequest) {
        Channel channel = new Channel();
        channel.setNotificationChannel(createChannelRequest.getNotificationChannel());
        channel.setEnabled(createChannelRequest.getEnabled());

        return channelRepository.save(channel);
    }

    public Channel enable(NotificationChannel notificationChannel) {
        Channel channel = channelRepository.getOneByNotificationChannel(notificationChannel);

        if (channel == null) {
            throw new EntityNotFoundException();
        }

        channel.setEnabled(true);
        return channelRepository.save(channel);
    }

    public Channel disable(NotificationChannel notificationChannel) {
        Channel channel = channelRepository.getOneByNotificationChannel(notificationChannel);

        if (channel == null) {
            throw new EntityNotFoundException();
        }

        channel.setEnabled(false);
        return channelRepository.save(channel);
    }

    public List<Channel> getSupportedChannels() {
        return channelRepository.findByEnabled(true);
    }
}
