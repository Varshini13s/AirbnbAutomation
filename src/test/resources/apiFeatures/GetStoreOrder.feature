@api
Feature: Validate Create Store Order

  Scenario: Verify user can create store order
    Given user wants to call "/store/order" end point
    And set header "Content-Type" to "application/json"
    And set header "Accept" to "application/json"
    And set request body from file "create_order.json" using pojo
    When user performs post call
    Then verify status code is 200
    And verify response body matches request body of create order
    And store "id" into "registration.id"
    Given user wants to call "/store/order/@id" end point
    And set header "Accept" to "application/json"
    When user performs get call
    Then verify status code is 200
    And verify response matches schema "create_order_response_schema.json"