Feature: Validate Wishlist Functionality

  Background:
    Given user open website or application
    Then verify user is on home page
    When user click on login icon
    And user click on login option
    Then verify login popup is displayed
    When user selects the country "country.name" with code "country.code"
    And user enter valid credential "phone.number"
    Then verify otp popup is displayed
    When user enter the otp

  @web @mobile
  Scenario: Verify user can add a place to wishlist
    When user click on add to wishlist button on the image
    And user create new wishlist with name "wishlist.name"
    When user click on wishlists icon
    Then verify wishlist with name "wishlist.name" is displayed

  @web
  Scenario: Verify user can delete a place from wishlist
    When user click on wishlists icon
    Then verify wishlist with name "wishlist.name" is displayed
    When user click on wishlist "wishlist.name"
    And user deselect wishlist button on the image
    Then verify the place is removed from the wishlist

  @mobile
  Scenario: Verify user can delete wishlist
    When user click on wishlists icon
    Then verify wishlist with name "wishlist.name" is displayed
    When user click on edit button
    And user delete wishlist
    Then verify the saved wishlist "wishlist.name" is removed

