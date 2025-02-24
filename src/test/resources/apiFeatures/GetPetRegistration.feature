@api
Feature: Validate Pet Registration

  Scenario: Verify user can create and get pet registration using valid id
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

  Scenario Outline: Verify user cannot get pet registration using invalid id
    Given user wants to call "/pet/<invalidId>" end point
    And set header "Content-Type" to "application/json"
    When user performs get call
    Then verify status code is 404
    And verify response body has a field "message" is "Pet not found"

    Examples:
      | invalidId |
      | 13478     |
      | -145      |
      | 89        |