package com.bargain.notification.client;

import com.bargain.notification.client.dto.NotificationReceiverDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

public class NotificationReceiverClient implements NotificationReceiverController {

    private RestTemplate restTemplate;

    private String url;

    public NotificationReceiverClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public NotificationReceiverDto create(@Valid NotificationReceiverDto notificationReceiverDto) {
        String url = UriComponentsBuilder.fromHttpUrl(this.url + NotificationReceiverController.PATH).toString();

        HttpEntity<NotificationReceiverDto> requestEntity = new HttpEntity<>(notificationReceiverDto);

        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                NotificationReceiverDto.class
        ).getBody();
    }

    @Override
    public NotificationReceiverDto update(@Valid NotificationReceiverDto notificationReceiverDto) {
        String url = UriComponentsBuilder.fromHttpUrl(this.url + NotificationReceiverController.PATH).toString();

        HttpEntity<NotificationReceiverDto> requestEntity = new HttpEntity<>(notificationReceiverDto);

        return restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                NotificationReceiverDto.class
        ).getBody();
    }
}
