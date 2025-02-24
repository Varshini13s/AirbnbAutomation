@api
Feature: Validate Updating Of Pet Registration

  Background:
    Given user wants to call "/pet" end point
    And set header "Content-Type" to "application/json"
    And set header "Accept" to "application/json"
    And set request body from file "register_pet.json"
    When user performs post call
    Then verify status code is 200
    And store "id" into "pet.id"
    Given user wants to call "/pet/@id" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200

  Scenario: Verify user can update pet name and status
    Given user wants to call "/pet/@id" end point
    And set header "Accept" to "application/json"
    And set header "Content-Type" to "application/x-www-form-urlencoded"
    And set field "name" with value "shitzu" as form data
    And set field "status" with value "not available" as form data
    When user performs post call
    Then verify status code is 200