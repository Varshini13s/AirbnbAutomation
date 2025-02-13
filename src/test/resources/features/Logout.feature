Feature: Validate on logout functionality

  Background:
    Given user open website
    When user click on profile icon
    And user click on login option
    Then verify login popup is displayed
    When user enter valid credentials "country.name", "country.code" and "phone.number"
    Then verify otp popup is displayed
    When user enter the otp
    Then verify login is successful

  Scenario: Verify user can logout successfully
    When user click on logout option
    Then verify logout is successful