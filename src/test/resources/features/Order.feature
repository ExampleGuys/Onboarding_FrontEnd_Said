Feature: MyComp Test

  @ONB2-161
  Scenario: ONB2-161 New Order" button should be clickable.
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    Then the user should be redirected to the new order creation page

  @ONB2-175
  Scenario: ONB2 - 175 User should be able to view new orders information under the "list of the orders" section
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
   # And user clicks "New Contact" button
   # And user clicks in the "Title" text area
   # And user choose an option from "Shipping Address" drop down menü.
   # And user selects date from "Preferred Delivery Date" box.
   # And user choose a Priority from Priority drop down menü.
   # And user type reason for request in "Reason for Request" box.
   # And in "Process" user chooses an approver from "Approver" ddm.
   # And in "Service Provider" user chooses a contact from "Contact" ddm.
   # And user clicks "Create" button
   # Then user should be able to verify that new order is in the "Orders list

  @ONB2-180
  Scenario: ONB2-180 The user should be able to create the new Company on "New Order" page.
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    And The user clicks the "Company" icon.
    #Then The user should be able to create the new Company.

  @ONB2-186
  Scenario: ONB2 -186 The back button on the "New orders" page should work properly
    Given The user goes to the sign-in page
    When user logs in with the valid credentials
    And Click on the "Orders" section in the Navigation Menu
    And The user click on the "New Order" button.
    And The user click on the "Back" button.
    Then the user should be able to redirect back to the List of Orders page again.

  #@ONB2-217
  #Scenario: User should be able to create a new (approver) user type
      # Given user goes to the test environment as a admin
      # When user enters valid user email and user password
      # And user clicks sign in button
      # And user clicks "Orders" from the navigation menu
      # And user clicks "New Order" button
      # And user scrolls to the bottom of the page.
      # And user clicks "Approver" icon.
      # And user fills in all required fields properly
      # And user clicks the Ok button
      # Then user should be able to create a new approver user type

