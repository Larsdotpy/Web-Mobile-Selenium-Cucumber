@Web @Regression
  Feature: When the user navigates to the main page. The expected behavior is that the page shows all the available options
    for valuta when clicked

  Scenario: Valuta options
    Given User navigates to the main page
    And Cookie pop up notification is shown
    And User accepts cookie notification
    When User clicks on valuta options
    Then All valuta options must consist of valutaList

