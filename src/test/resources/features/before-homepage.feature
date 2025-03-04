Feature: Disclaimer Handling

  Scenario: User launches the app and handles the disclaimer, leading to the homepage
    Given the app is launched
    When the disclaimer page appears
    Then the user should accept the disclaimer
    Then location access prompt displayes
    Then  the user close the prompt
    Then promotion page displayes
    Then  the user close the promotion page
#    Then the user click ok to proceed to
#    And the homepage should load successfully
