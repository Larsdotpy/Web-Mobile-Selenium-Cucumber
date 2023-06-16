@Web @Regression
Feature: Search Hotel
  Scenario Outline: User visits the homepage and searches for a hotel and sets
  total amount of guests and rooms, after which the top 5 hotels with their prices
  are returned in the console

    Given User navigates to the homepage
    And Cookie popup is displayed
    And User accepts cookie notification
    And User types "<bestemming>" and presses ENTER
    And User's arrival date is today
    And User's depart date is <aantal dagen> days later
    And User selects <aantal volwassenen> adults, <aantal kinderen> children and <aantal kamers> rooms
   #And User selects random age per child between zero and seventeen
    Then User presses the search button
    And The top 5 hotels are retrieved with their prices

    Examples:
      | bestemming  |     aantal dagen    | aantal volwassenen  | aantal kinderen | aantal kamers |
      | Rotterdam   |           8         |         5           |       5         |       3       |
      | Barcelona   |           3         |         2           |       2         |       2       |
      | Rome        |           5         |         12          |       3         |       6       |
