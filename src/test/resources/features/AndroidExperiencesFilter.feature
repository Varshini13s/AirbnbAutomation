@mobile
Feature: Validate Experiences Filter Options
  Background:
    Given user open website or application
    Then verify user is on home page
    When user click on experiences button
    Then verify experiences button is selected
    When user selects "destination.experiences.name", "checkin.date" and "checkout.date"
    And user selects number of guests
    Then verify activities are displayed

  Scenario: Verify user can search activities by applying price filter
    When user click on filters button in experiences page
    And user selects prices "minimum.price" and "maximum.price" for activities
    Then verify price filter is applied to activities