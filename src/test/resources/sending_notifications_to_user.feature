Feature: Sending notifications to a user using all available channels
  In order to keep track of newest changes in Bargain Service
  As a Customer
  I want to be notified about every new interesting deal

  Background:
    Given there is a customer John who subscribed to notifications on all channels

  Scenario: Sending notification using email channel
    Given John's email address is john.doe@gmail.com
    And notification channel EMAIL is enabled
    When a message Hey! New bargains arrived! is sent to John
    Then it should be sent to john.doe@gmail.com email address
    And it should be sent once

  Scenario: Sending notification using sms channel
    Given John's phone number is 111-222-333
    And notification channel SMS is enabled
    When a message Hey! New bargains arrived! is sent to John
    Then it should be sent to 111-222-333 phone number
    And it should be sent once

  @problem
  Scenario: Sending notification to the Bargain Service user using all channels
    Given John's email address is john.doe@gmail.com
    And John's phone number is 111-222-333
    And notification channel SMS is enabled
    And notification channel EMAIL is enabled
    When a message Hey! New bargains arrived! is sent to John
    Then it should be sent twice
