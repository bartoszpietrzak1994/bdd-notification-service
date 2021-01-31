package com.bargain.notifications.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelDto {

    @NotNull
    private NotificationChannel notificationChannel;

    @NotNull
    private Boolean enabled;
}
