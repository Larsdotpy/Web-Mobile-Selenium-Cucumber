@Mobile
  Feature: When a mobile user lands on the main page
    the expected behavior of the website is to show a pop up of a cookie notification

  Scenario: Mobile cookie notification on main page
    Given Mobile user navigates to the main page
    Then Mobile cookie pop up notification is shown