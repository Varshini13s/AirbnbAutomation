@api
Feature: Validate Deletion Of Pet Registration

  Background:
    Given user wants to call "/pet" end point
    And set header "Content-Type" to "application/json"
    And set header "Accept" to "application/json"
    And set request body from file "register_pet.json"
    When user performs post call
    Then verify status code is 200
    And store "id" into "registration.id"
    Given user wants to call "/pet/@id" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 200

  Scenario: Verify user can delete pet registration with created id
    Given user wants to call "/pet/@id" end point
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "/pet/@id" end point
    When user performs get call
    Then verify status code is 404
