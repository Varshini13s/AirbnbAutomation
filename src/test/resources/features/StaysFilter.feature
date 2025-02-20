@web @mobile
Feature: Validate Stays Filter Options

  Background:
    Given user open website or application
    Then verify user is on home page
    And verify stays button is selected
    When user selects "destination.stays.name", "checkin.date" and "checkout.date"
    And user selects number of guests
    Then verify places are displayed

  Scenario: Verify user can search places by applying price filter
    When user click on filters button in stays page
    And user selects prices "minimum.price" and "maximum.price"
    Then verify price filter is applied to places

  Scenario: Verify user can search places by applying amenities filter
    When user click on filters button in stays page
    And user selects amenities "amenities.option"
    Then verify amenities filter is applied to places

  Scenario: Verify user can search places by applying host language filter
    When user click on filters button in stays page
    And user selects host language "host.language"
    Then verify host language filter is applied to places






