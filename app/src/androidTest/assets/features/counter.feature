Feature: Counter
  The application displays a counter that can be incremented and decremented

  Scenario: On initial load the counter displays '0'
    When the application starts
    Then the counter should display "0"