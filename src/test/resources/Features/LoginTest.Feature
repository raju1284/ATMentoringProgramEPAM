Feature: Login Test Feature
  Scenario Outline: Validate the login functionality for the report portal
    Given User open the report portal URL
    When User login the report portal with valid "<username>" and "<password>"
    Then Validate the Login should be successful

    Examples:
    |username |password   |
    |raju1284 |Devraj@1284|
    |raju4792|Devraj@1284|