@api
Feature: Validate End To End Scenario

  Scenario: Verify user can create, get and delete the pet store order
    Given user wants to call "/store/order" end point
    And set header "Content-Type" to "application/json"
    And set header "Accept" to "application/json"
    And set request body from file "create_order.json"
    When user performs post call
    Then verify status code is 200
    And store "id" into "registration.id"
    Given user wants to call "/store/order/@id" end point
    And set header "Accept" to "application/json"
    When user performs get call
    Then verify status code is 200
    Given user wants to call "/store/order/@id" end point
    And set header "Accept" to "application/json"
    When user performs delete call
    Then verify status code is 200
    Given user wants to call "/store/order/@id" end point
    When user performs get call
    Then verify status code is 404
    And verify response body has a field "message" is "Order not found"