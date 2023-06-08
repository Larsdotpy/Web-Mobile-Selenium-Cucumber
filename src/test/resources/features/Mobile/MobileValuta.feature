@Mobile

  Feature: When the mobile user navigates to the main page. The expected behavior is that the page shows all the available options
    for valuta when clicked

  Scenario: Mobile valuta options
    Given Mobile user navigates to the main page
    And Mobile cookie pop up notification is shown
    And Mobile user accepts cookie notification
    When Mobile user clicks on valuta options
    Then Mobile all valuta options must consist of valutaList