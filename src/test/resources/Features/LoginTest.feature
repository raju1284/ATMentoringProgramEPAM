Feature: Login Test Feature
  Scenario Outline: Validate the login functionality for the report portal
    Given User login the report portal with valid username "<username>" and password "<password>"
    Then Verify that user was logged in successful

    Examples:
      |username |password   |
      |raju1284 |Devraj@1284|
      |raju4792|Devraj@1284|