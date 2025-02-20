@web @mobile
Feature: Validate Login Feature

  Background:
    Given user open website or application
    Then verify user is on home page
    When user click on login icon
    And user click on login option
    Then verify login popup is displayed

  Scenario: Verify user can login with valid credentials
    When user selects the country "country.name" with code "country.code"
    And user enter valid credential "phone.number"
    Then verify otp popup is displayed
    When user enter the otp
    Then verify login is successful

  Scenario Outline: Verify user cannot login with invalid credentials
    When user selects the country "country.name" with code "country.code"
    And user enter invalid credential "<invalid.phone.number>"
    Then verify error message is displayed

    Examples:
      | invalid.phone.number |
      | 86346                |
      | 8356289103889        |
      | 00000                |
      | 9467                 |
      |                      |



