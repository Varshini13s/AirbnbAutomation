@web @mobile
Feature: Validate Feedback Functionality

  Background:
    Given user open website or application
    Then verify user is on home page
    When user click on login icon
    And user click on login option
    Then verify login popup is displayed
    When user selects the country "country.name" with code "country.code"
    And user enter valid credential "phone.number"
    Then verify otp popup is displayed
    When user enter the otp

  Scenario: Verify user can submit the feedback
    When user click on profile icon
    And click on give us feedback option
    Then verify user is on feedback page
    When user select feedback theme "feedback.theme"
    And user select feedback type "feedback.type"
    And user gives feedback message "feedback.message"
    Then verify feedback is shared successfully
