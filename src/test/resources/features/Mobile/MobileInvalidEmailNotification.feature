@Mobile
  Feature: When a mobile user enters an invalid email
    a notification is shown in red that email is invalid

  Scenario: Invalid email notification for mobile
    Given Mobile user navigates to the main page
    And Mobile user accepts cookie notification
    And Mobile user clicks on login button
    When Mobile User enters an invalid email
    Then Mobile A notification is shown displaying "Voer je volledige e-mailadres in. Bijvoorbeeld: naam@voorbeeld.com" and has "#db3734" hex color value