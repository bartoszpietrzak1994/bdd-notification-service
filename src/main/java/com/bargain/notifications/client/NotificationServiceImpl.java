package com.bargain.notifications.client;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notifications.model.Channel;
import com.bargain.notifications.model.NotificationReceiver;
import com.bargain.notifications.repository.NotificationReceiverRepository;
import com.bargain.notifications.sender.NotificationSender;
import com.bargain.notifications.service.ChannelService;
import com.bargain.notifications.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private ChannelService channelService;

    @Autowired
    private List<NotificationSender> notificationSenders;

    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    @Override
    public void send(String message, String userReference) {
        NotificationReceiver notificationReceiver = notificationReceiverRepository.getOneByUserReference(userReference);
        Set<NotificationChannel> receiverNotificationChannels = notificationReceiver.getNotificationChannels();

        List<NotificationChannel> supportedChannels = channelService.getSupportedChannels().stream()
                .map(Channel::getNotificationChannel).collect(Collectors.toList());

        for (NotificationChannel notificationChannel : receiverNotificationChannels) {
            if (supportedChannels.contains(notificationChannel)) {
                notificationSenders.stream().filter(sender -> sender.getChannel().name()
                        .equals(notificationChannel.name()))
                        .findFirst()
                        .orElseThrow().send(message, notificationReceiver);
            }
        }
    }
}
