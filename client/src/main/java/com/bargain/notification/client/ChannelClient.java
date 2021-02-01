package com.bargain.notification.client;

import com.bargain.notification.client.dto.ChannelDto;
import com.bargain.notification.client.dto.request.CreateChannelRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

public class ChannelClient implements ChannelController {

    private RestTemplate restTemplate;

    private String url;

    public ChannelClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public ChannelDto create(@Valid CreateChannelRequest createChannelRequest) {
        Map<String, String> pathParams = new HashMap<>();
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

        String url = UriComponentsBuilder.fromHttpUrl(this.url + ChannelController.PATH)
                .queryParams(queryParams)
                .build(pathParams)
                .toString();

        HttpEntity<CreateChannelRequest> requestEntity = new HttpEntity<>(createChannelRequest);
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                ChannelDto.class
        ).getBody();
    }

    @Override
    public ChannelDto enable(String channelType) {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("channelType", channelType);

        String url = UriComponentsBuilder
                .fromHttpUrl(String.format("%s/%s/%s/%s", this.url, ChannelController.PATH, "{channelType}", "enable"))
                .build(pathParams)
                .toString();

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                null,
                ChannelDto.class
        ).getBody();
    }

    @Override
    public ChannelDto disable(String channelType) {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("channelType", channelType);

        String url = UriComponentsBuilder
                .fromHttpUrl(String.format("%s/%s/%s/%s", this.url, ChannelController.PATH, "{channelType}", "disable"))
                .build(pathParams)
                .toString();

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                null,
                ChannelDto.class
        ).getBody();
    }
}
