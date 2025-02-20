Feature: Validate Total Price Including Taxes

  Background:
    Given user open website or application
    Then verify user is on home page
    And verify stays button is selected
    When user selects "destination.stays.name", "checkin.date" and "checkout.date"
    And user selects number of guests
    Then verify places are displayed

  Scenario: Verify price consistency of place across pages
    When user get price of first place from stays page
    And user click on first place
    Then verify price is same in p page