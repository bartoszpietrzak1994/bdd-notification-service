package com.bargain.notifications.client;

import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.dto.request.CreateChannelRequest;
import com.bargain.notifications.model.Channel;
import com.bargain.notifications.repository.ChannelRepository;
import com.bargain.notifications.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public Channel createChannel(CreateChannelRequest createChannelRequest) {
        Channel channel = new Channel();
        channel.setNotificationChannel(createChannelRequest.getNotificationChannel());
        channel.setEnabled(createChannelRequest.getEnabled());

        return channelRepository.save(channel);
    }

    @Override
    public Channel enableChannel(NotificationChannel notificationChannel) {
        Channel channel = channelRepository.getOneByNotificationChannel(notificationChannel);

        if (channel == null) {
            throw new EntityNotFoundException();
        }

        channel.setEnabled(true);
        return channelRepository.save(channel);
    }

    @Override
    public Channel disableChannel(NotificationChannel notificationChannel) {
        Channel channel = channelRepository.getOneByNotificationChannel(notificationChannel);

        if (channel == null) {
            throw new EntityNotFoundException();
        }

        channel.setEnabled(false);
        return channelRepository.save(channel);
    }

    @Override
    public List<Channel> getSupportedChannels() {
        return channelRepository.findByEnabled(true);
    }
}
