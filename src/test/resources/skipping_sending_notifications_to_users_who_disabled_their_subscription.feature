Feature: Skipping sending notifications to users who disabled their subscription
  In order not to be notified about new deals
  As a Customer
  I want to be able to disable notifications subscription

  Background:
    Given there is a customer John who disabled his notifications subscription
    And notification channel SMS is enabled
    And notification channel EMAIL is enabled
    And John's email address is john.doe@gmail.com
    And John's phone number is 111-222-333

  Scenario: Sending single notification using email channel
    When a message Hey! New bargains arrived! is sent to John
    Then no notification should be sent
