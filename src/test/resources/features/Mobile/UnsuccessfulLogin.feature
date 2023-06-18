@Mobile
Feature: Unsuccessful login
  Scenario: User tries to login with invalid credentials and this results in an unsuccessful login

    Given I start the Trivago app with english language settings
    And I accept the cookies
    And I skip price alerts notifications
    Then I click on settings
    And I press the login button
    #Then I press accept and continue in Chrome
    #And I decline the option to turn on sync
    Then I use an invalid email and password
    And I attempt to login
    #Then An error message is displayed

    #While writing this test framework the Android developers of Trivago have not implemented a locator
    #for the error message. It is part of the entire view and not a separate container to access.
    #Therefore, this step will be omitted.