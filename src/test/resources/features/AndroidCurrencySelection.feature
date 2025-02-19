Feature: Validate Currency Selection Functionality

  Scenario Outline: Verify user can select different currencies
    When user open website or application
    Then verify user is on home page
    When user click on profile icon
    And user click on payments option
    Then verify user is on payments page
    When user click on currency "<currency.option>"
    And user select a currency
    Then verify currency is applied


    Examples:
      | currency.option      |
      | United States dollar |
      | Canadian dollar      |
      | Indian rupee         |
      | Euro                 |
