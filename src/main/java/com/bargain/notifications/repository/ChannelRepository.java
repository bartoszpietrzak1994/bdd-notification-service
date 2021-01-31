package com.bargain.notifications.repository;

import com.bargain.notifications.dto.NotificationChannel;
import com.bargain.notifications.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel getOneByNotificationChannel(NotificationChannel notificationChannel);

    List<Channel> findByEnabled(Boolean enabled);
}
