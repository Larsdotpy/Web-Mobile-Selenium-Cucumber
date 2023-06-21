@Mobile
Feature: Add random hotel to favorites
  Scenario: Add random hotel to favorites
    Given I start the Trivago app with english language settings
    Then I accept the cookies
    And I skip price alerts notifications
    And I press the search button without filling out details
    And I press on the maps button
    And I select a random hotel on the map
    And I add the hotel to my favorites
    Then I go back to the homescreen
    And I select favorites
    Then The hotel is successfully added