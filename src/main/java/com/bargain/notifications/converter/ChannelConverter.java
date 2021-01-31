package com.bargain.notifications.converter;

import com.bargain.notifications.dto.ChannelDto;
import com.bargain.notifications.model.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ChannelConverter {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    Channel toModel(ChannelDto channelDto);

    ChannelDto toDto(Channel channel);
}
