@ignore
Feature: Sending notifications to a user using sms channel
  In order to keep track of newest changes in Bargain Service
  As a Customer
  I want to be notified about every new interesting deal by sms

  Background:
    Given there is a customer John who subscribed to notifications on SMS channel
    And notification channel SMS is enabled
    And notification channel EMAIL is enabled
    And John's email address is john.doe@gmail.com
    And John's phone number is 111-222-333

  Scenario: Sending single notification using email channel
    When a message Hey! New bargains arrived! is sent to John
    Then it should be sent to 111-222-333 phone number
    And it should be sent once
