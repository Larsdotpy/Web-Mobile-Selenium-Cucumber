@Mobile
  Feature: User successfully retrieves the hotel name and price

  Scenario: The user gets the hotelname and the price of a random hotel nearby
    Given I start the Trivago app with english language settings
    Then I accept the cookies
    And I skip price alerts notifications
    And I press the search button without filling out details
    And I press on the maps button
    And I select a random hotel on the map
    And I retrieve the name of the hotel
    And I retrieve the corresponding price

