@mobile
Feature: Validate Currency Selection Functionality

  Scenario Outline: Verify user can select different currencies
    When user open website or application
    Then verify user is on home page
    When user click on login icon
    And user click on settings option
    Then verify user is on settings page
    When user click on currency option
    And user select currency "<currency.option>"
    When user navigates to home page
    Then verify currency is displayed


    Examples:
      | currency.option      |
      | United States dollar |
      | Canadian dollar      |
      | South Korean won     |
      | Euro                 |
