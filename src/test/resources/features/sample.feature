Feature: Simple String Processing

  Scenario: Convert input to uppercase
    Given I have a string input
    When I set the input to "hello"
    And I process the input
    Then the output should be "HELLO"
