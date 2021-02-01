package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import com.bargain.notifications.controller.ChannelControllerImpl;
import com.bargain.notification.client.dto.NotificationChannel;
import com.bargain.notification.client.dto.request.CreateChannelRequest;
import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.java.en.Given;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ChannelSteps extends SpringTest {

    @Given("^notification channel (.*) is enabled$")
    public void notification_channel_is_enabled(String channel) {
        NotificationChannel notificationChannel = NotificationChannel.valueOf(channel);

        try {
            createEnabledChannel(notificationChannel);
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    private void createEnabledChannel(NotificationChannel notificationChannel) throws Exception {
        CreateChannelRequest createChannelRequest = new CreateChannelRequest();
        createChannelRequest.setEnabled(true);
        createChannelRequest.setNotificationChannel(notificationChannel);

        MockHttpServletResponse response = this.mockMvc
                .perform(post(ChannelControllerImpl.PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createChannelRequest))
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        handleResponseStatus(response.getStatus());
    }

    private void handleResponseStatus(int status) throws Exception {
        if (status >= 200 && status < 300) {
            sharedStorage.set("response_success", true);
            return;
        }

        throw new Exception(String.format("Unexpected http code %d", status));
    }
}
