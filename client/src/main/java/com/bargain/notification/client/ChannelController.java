package com.bargain.notification.client;

import com.bargain.notification.Constants;
import com.bargain.notification.client.dto.ChannelDto;
import com.bargain.notification.client.dto.request.CreateChannelRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(ChannelController.PATH)
public interface ChannelController {

    String PATH = Constants.VI_API_PREFIX + "/channel";

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ChannelDto create(@Valid @RequestBody CreateChannelRequest createChannelRequest);

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/{channelType}/enable", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    ChannelDto enable(@PathVariable String channelType);

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(path = "/{channelType}/disable", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
            MediaType.APPLICATION_JSON_VALUE})
    ChannelDto disable(@PathVariable String channelType);
}
