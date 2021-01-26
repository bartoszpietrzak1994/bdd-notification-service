package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;

public class CustomerSteps extends SpringTest {

    @Given("^there is a customer (.*) who subscribed to notifications on all channels$")
    public void there_is_a_customer_who_subscribed_to_all_channels(String name) {
        createCustomerWithName(name);

        throw new PendingException();
    }

    @Given("^there is a customer (.*) who subscribed to notifications on (.*) channel$")
    public void there_is_a_customer_who_subscribed_to_channel(String name, String channel) {
        createCustomerWithName(name);

        throw new PendingException();
    }

    @Given("^(.*)'s email address is (.*)$")
    public void email_address_is(String email) {
        throw new PendingException();
    }

    @Given("^(.*)'s phone number is (.*)$")
    public void phone_number_is(String phoneNumber) {
        throw new PendingException();
    }

    @Given("^there is a customer (.*) who disabled his notifications subscription$")
    public void there_is_a_customer_who_disabled_notifications(String name) {
        createCustomerWithName(name);

        throw new PendingException();
    }

    private void createCustomerWithName(String name) {

    }
}
