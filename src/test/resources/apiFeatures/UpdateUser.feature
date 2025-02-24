@api
Feature: Validate Updating Of User Registration

  Background:
    Given user wants to call "/user" end point
    And set header "Content-Type" to "application/json"
    And set header "Accept" to "application/json"
    And set request body from file "register_user.json"
    When user performs post call
    Then verify status code is 200
    Given user wants to call "/user/@username" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200

  Scenario: Verify user can update lastname
    Given user wants to call "/user/@username" end point
    And set header "Accept" to "application/json"
    And set header "Content-Type" to "application/json"
    And set request body from file "register_user.json" with "lastName" value "kitty"
    When user performs put call
    Then verify status code is 200