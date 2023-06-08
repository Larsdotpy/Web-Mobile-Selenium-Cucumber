@Web @Regression
  Feature: When a user enters an invalid email
    a notification is shown in red that email is invalid

  Scenario: Invalid email notification
    Given User navigates to the main page
    And User accepts cookie notification
    And User clicks on login button
    When User enters an invalid email
    Then A notification is shown displaying "Voer je volledige e-mailadres in. Bijvoorbeeld: naam@voorbeeld.com" and has "#db3734" hex color value