@Mobile
Feature: Successful login
  Scenario: User tries to login with valid credentials and this results in an successful login

    Given I start the Trivago app with english language settings
    And I accept the cookies
    And I skip price alerts notifications
    Then I click on settings
    And I press the login button
    Then I use a valid email
    And I click NEXT
    And I use a valid password
    And I attempt to login
    Then I am successfully logged in
