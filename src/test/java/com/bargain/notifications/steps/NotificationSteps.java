package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class NotificationSteps extends SpringTest {

    @Given("^notification channel (.*) is enabled$")
    public void notification_channel_is_enabled(String channel) {
        throw new PendingException();
    }

    @When("^a message (.*) is sent to (.*)$")
    public void message_is_sent(String message, String name) {
        throw new PendingException();
    }

    @Then("^it should be sent to (.*) email address$")
    public void should_be_sent_to_email_address(String email) {
        throw new PendingException();
    }

    @Then("^it should be sent to (.*) phone number$")
    public void should_be_sent_to_phone_number(String phoneNumber) {
        throw new PendingException();
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

    private int getNotificationsCount() {
        return -1;
    }
}
