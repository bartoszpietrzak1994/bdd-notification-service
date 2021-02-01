package com.bargain.notifications.model;

import com.bargain.notification.client.dto.NotificationChannel;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "notification_receiver")
public class NotificationReceiver extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "user_reference")
    private String userReference;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<NotificationChannel> notificationChannels = new HashSet<>();
}
