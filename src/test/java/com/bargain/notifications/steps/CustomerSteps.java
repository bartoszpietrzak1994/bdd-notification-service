package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import com.bargain.notifications.controller.NotificationReceiverControllerImpl;
import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notification.client.dto.NotificationReceiverDto;
import com.bargain.notifications.repository.NotificationReceiverRepository;
import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

public class CustomerSteps extends SpringTest {

    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    public static final String USER_SHARED_STORAGE_PATTERN = "user_%s";

    @Given("^there is a customer (.*) who subscribed to notifications on all channels$")
    public void there_is_a_customer_who_subscribed_to_all_channels(String name) {
        NotificationReceiverDto notificationReceiver = createCustomerWithName(name);

        notificationReceiver.getNotificationChannels().add(NotificationChannel.EMAIL);
        notificationReceiver.getNotificationChannels().add(NotificationChannel.SMS);

        try {
            updateNotificationReceiver(name, notificationReceiver);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    @Given("^there is a customer (.*) who subscribed to notifications on (.*) channel$")
    public void there_is_a_customer_who_subscribed_to_notifications_on_channel(String name, String channel) {
        NotificationReceiverDto notificationReceiver = createCustomerWithName(name);
        NotificationChannel notificationChannel = NotificationChannel.valueOf(channel);
        notificationReceiver.getNotificationChannels().add(notificationChannel);

        try {
            updateNotificationReceiver(name, notificationReceiver);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    @Given("^(.*)'s email address is (.*)$")
    public void email_address_is(String name, String email) {
        NotificationReceiverDto notificationReceiver = (NotificationReceiverDto) sharedStorage
                .get(String.format(USER_SHARED_STORAGE_PATTERN, name));

        notificationReceiver.setEmail(email);

        try {
            updateNotificationReceiver(name, notificationReceiver);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    @Given("^(.*)'s phone number is (.*)$")
    public void phone_number_is(String name, String phoneNumber) {
        NotificationReceiverDto notificationReceiver = (NotificationReceiverDto) sharedStorage
                .get(String.format(USER_SHARED_STORAGE_PATTERN, name));

        notificationReceiver.setPhoneNumber(phoneNumber);

        try {
            updateNotificationReceiver(name, notificationReceiver);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    @Given("^there is a customer (.*) who disabled his notifications subscription$")
    public void there_is_a_customer_who_disabled_notifications(String name) {
        createCustomerWithName(name);
    }

    private NotificationReceiverDto createCustomerWithName(String name) {
        String userReference = UUID.randomUUID().toString();
        NotificationReceiverDto notificationReceiverDto = NotificationReceiverDto.builder()
                .userReference(userReference)
                .build();

        NotificationReceiverDto savedNotificationReceiver = null;
        try {
            savedNotificationReceiver = createNotificationReceiver(name, notificationReceiverDto);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }

        return savedNotificationReceiver;
    }

    private NotificationReceiverDto createNotificationReceiver(String name,
            NotificationReceiverDto notificationReceiverDto)
            throws Exception {
        return interactWithNotificationReceiver(name, notificationReceiverDto, HttpMethod.POST);
    }

    private NotificationReceiverDto updateNotificationReceiver(String name,
            NotificationReceiverDto notificationReceiverDto)
            throws Exception {
        return interactWithNotificationReceiver(name, notificationReceiverDto, HttpMethod.PUT);
    }

    private NotificationReceiverDto interactWithNotificationReceiver(String name,
            NotificationReceiverDto notificationReceiverDto, HttpMethod httpMethod) throws Exception {
        int status;

        MockHttpServletRequestBuilder requestBuilder =
                httpMethod == HttpMethod.POST ? post(NotificationReceiverControllerImpl.PATH)
                        : put(NotificationReceiverControllerImpl.PATH);
        MockHttpServletResponse response = this.mockMvc
                .perform(requestBuilder
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(notificationReceiverDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        status = response.getStatus();
        handleResponseStatus(status);
        NotificationReceiverDto responseDto = objectMapper
                .readValue(response.getContentAsString(), NotificationReceiverDto.class);
        sharedStorage.set(String.format(USER_SHARED_STORAGE_PATTERN, name), responseDto);

        return responseDto;
    }

    private void handleResponseStatus(int status) throws Exception {
        if (status >= 200 && status < 300) {
            sharedStorage.set("response_success", true);
            return;
        }

        throw new Exception("Unexpected http code");
    }
}
