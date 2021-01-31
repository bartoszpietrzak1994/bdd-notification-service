package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import com.bargain.notifications.controller.NotificationController;
import com.bargain.notifications.dto.NotificationReceiverDto;
import com.bargain.notifications.dto.request.SendNotificationRequest;
import io.cucumber.core.backend.CucumberBackendException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class NotificationSteps extends SpringTest {

    @When("^a message (.*) is sent to (.*)$")
    public void message_is_sent(String message, String name) {
        NotificationReceiverDto notificationReceiver = (NotificationReceiverDto) sharedStorage
                .get(String.format(CustomerSteps.USER_SHARED_STORAGE_PATTERN, name));

        try {
            sendNotification(message, notificationReceiver.getUserReference());
        } catch (Exception e) {
            throw new CucumberBackendException(e.getMessage());
        }
    }

    @Then("^it should be sent to (.*) email address$")
    public void should_be_sent_to_email_address(String email) {
        String message = (String) sharedStorage.get("message");
        verify(emailGateway).send(eq(message), eq(email));
    }

    @Then("^it should be sent to (.*) phone number$")
    public void should_be_sent_to_phone_number(String phoneNumber) {
        String message = (String) sharedStorage.get("message");
        verify(smsGateway).send(eq(message), eq(phoneNumber));
    }

    @Then("^it should be sent once$")
    public void message_should_be_sent_once() {
        assertThat(1).isEqualTo(getNotificationsCount());
    }

    @Then("^it should be sent twice$")
    public void message_should_be_sent_twice() {
        assertThat(2).isEqualTo(getNotificationsCount());
    }

    @Then("^no notification should be sent$")
    public void no_notifications_should_be_sent() {
        assertThat(0).isEqualTo(getNotificationsCount());
    }

    private void sendNotification(String text, String userReference) throws Exception {
        SendNotificationRequest sendNotificationRequest = new SendNotificationRequest(text, userReference);

        int status = this.mockMvc.perform(post(NotificationController.PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(sendNotificationRequest))
                .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getStatus();

        handleResponseStatus(status);

        sharedStorage.set("message", text);
    }

    private int getNotificationsCount() {
        return Mockito.mockingDetails(emailGateway).getInvocations().size() +
                Mockito.mockingDetails(smsGateway).getInvocations().size();
    }

    private void handleResponseStatus(int status) throws Exception {
        if (status >= 200 && status < 300) {
            sharedStorage.set("response_success", true);
            return;
        }

        throw new Exception("Unexpected http code");
    }
}
