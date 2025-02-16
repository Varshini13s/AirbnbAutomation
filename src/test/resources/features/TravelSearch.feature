Feature: Validate Searching Functionality

  Scenario: Verify user can search in stays category
    Given user open website or application
    Then verify user is on home page
    And verify stays button is selected
    When user selects "destination.stays.name", "checkin.date" and "checkout.date"
    And user selects number of guests
    Then verify places are displayed

  Scenario: Verify user can search in experiences category
    Given user open website or application
    Then verify user is on home page
    When user click on experiences button
    Then verify experiences button is selected
    When user selects "destination.experiences.name", "checkin.date" and "checkout.date"
    And user selects number of guests
    Then verify activities are displayed