package com.bargain.notifications.channel;

import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notifications.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "notification_channel")
public class Channel extends BaseEntity {

    @Column(name = "channel", unique = true)
    @Enumerated(value = EnumType.STRING)
    private NotificationChannel notificationChannel;

    @Column(name = "enabled")
    private Boolean enabled;
}
