package com.bargain.notifications.dto.request;

import com.bargain.notifications.dto.NotificationChannel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateChannelRequest {

    @NotNull
    private NotificationChannel notificationChannel;

    @NotNull
    private Boolean enabled;
}
