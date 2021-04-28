package com.bargain.notifications.notification.receiver;

import com.bargain.notification.client.dto.NotificationReceiverDto;
import com.bargain.notifications.notification.receiver.NotificationReceiver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface NotificationReceiverConverter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    NotificationReceiver toModel(NotificationReceiverDto notificationReceiverDto);

    NotificationReceiverDto toDto(NotificationReceiver notificationReceiver);
}
