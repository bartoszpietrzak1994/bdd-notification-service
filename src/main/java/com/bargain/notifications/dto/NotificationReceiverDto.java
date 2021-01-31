package com.bargain.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationReceiverDto {

    private String email;

    private String phoneNumber;

    @NotBlank
    private String userReference;

    private Set<NotificationChannel> notificationChannels;
}
