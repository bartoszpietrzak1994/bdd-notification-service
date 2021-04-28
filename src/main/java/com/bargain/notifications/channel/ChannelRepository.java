package com.bargain.notifications.channel;

import com.bargain.notification.client.dto.NotificationChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel getOneByNotificationChannel(NotificationChannel notificationChannel);

    List<Channel> findByEnabled(Boolean enabled);
}
