Feature: MyComp Test

  @wip
  Scenario: ONB2-161 New Order" button should be clickable.
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    Then the user should be redirected to the new order creation page


  Scenario: ONB2-180 The user should be able to create the new Resource on "New Order" page.
   Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    #And The user clicks the "Resource" icon.
    #Then The user should be able to create the new Resource.

  @said
  Scenario: ONB2 -186 The back button on the "New orders" page should work properly
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    And The user click on the "Back" button.
    Then the user should be able to redirect back to the List of Orders page again.
