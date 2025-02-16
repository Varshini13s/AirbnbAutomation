Feature: Validate Logout Functionality

  Background:
    Given user open website or application
    Then verify user is on home page
    When user click on profile icon
    And user click on login option
    Then verify login popup is displayed
    When user selects the country "country.name" with code "country.code"
    And user enter valid credential "phone.number"
    Then verify otp popup is displayed
    When user enter the otp
    Then verify login is successful

  Scenario: Verify user can logout successfully
    When user click on logout option
    Then verify logout is successful