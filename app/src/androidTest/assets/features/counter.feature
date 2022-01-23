Feature: Counter
  The application displays a counter that can be incremented and decremented

  Scenario Outline: On initial load the counter displays '0'
    When the application starts
    Then the counter should display "<count>"

    Examples:
      | count |
      | 0 |

  Scenario Outline: The counter can be incremented
    Given the counter starts at <count>
    When the user increments the counter <x> times
    Then the counter should display "<result>"

    Examples:
      | count | x | result |
      | 5 | 5 | 10 |
      | 2 | 3 | 5 |

  Scenario Outline: The counter can be decremented
    Given the counter starts at <count>
    When the user decrements the counter <x> times
    Then the counter should display "<result>"

    Examples:
      | count | x | result |
      | 5 | 5 | 0 |
      | 3 | 2 | 1 |

  Scenario Outline: The counter cannot be decremented past '0'
    Given the counter starts at <count>
    When the user decrements the counter <x> times
    Then the counter should display "<result>"

    Examples:
      | count | x | result |
      | 3 | 5 | 0 |
      | 1 | 15 | 0 |