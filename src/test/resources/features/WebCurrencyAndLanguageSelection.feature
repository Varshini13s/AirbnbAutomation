@web
Feature: Validate Currency And Language Selection Functionality

  Background:
    When user open website or application
    Then verify user is on home page

  Scenario Outline: Verify user can select different currencies
    When user click on globe icon
    And user click on currency tab
    Then verify currency tab is selected
    When user select currency name "<currency.name>"
    Then verify currency symbol is displayed

    Examples:
      | currency.name        |
      | United States dollar |
      | South Korean won     |
      | Indonesian rupiah    |
      | Euro                 |
      | Thai baht            |


  Scenario Outline: Verify user can select different languages
    When user click on globe icon
    Then verify language tab is selected
    When user selects language "<language.name>"
    Then verify language is applied using "<attribute.value>"

    Examples:
      | language.name | attribute.value |
      | हिन्दी           | hi              |
      | Italiano      | it              |
      | Deutsch       | de              |



