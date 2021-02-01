package com.bargain.notification.client;

import com.bargain.notification.client.dto.request.SendNotificationRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class NotificationClient implements NotificationController {

    private RestTemplate restTemplate;

    private String url;

    public NotificationClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    @Override
    public void send(SendNotificationRequest sendNotificationRequest) {
        Map<String, String> pathParams = new HashMap<>();
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

        String url = UriComponentsBuilder.fromHttpUrl(this.url + NotificationController.PATH)
                .queryParams(queryParams)
                .build(pathParams)
                .toString();

        HttpEntity<SendNotificationRequest> requestEntity = new HttpEntity<>(sendNotificationRequest);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class
        );
    }
}
