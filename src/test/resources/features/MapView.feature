@web @mobile
Feature: Validate Map View Functionality

  Scenario: Verify places are displayed in the map view
    When user open website or application
    Then verify user is on home page
    And get details of first place
    When user click on map button
    Then verify location price marker of first place is displayed
    When user click on price marker
    Then verify place details is displayed