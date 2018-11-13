Feature: login
  Perform login on email and password are inputted

  @login-feature
  Scenario Outline: Input email and password invalid
    Given I am on login screen
    When I input username <username>
    And I input password "<password>"
    And I press submit button
    Then I should see error

    Examples:
      | username                | password  |
      | youturnmywholelifesoblue| tentofive |
      | nothingleftbutpieces    |           |


  @login-feature
  Scenario Outline: Input email and password valid
    Given I am on login screen
    When I input username <username>
    And I input password "<password>"
    And I press submit button
    Then I should see homepage

    Examples:
      | username     | password  |
      | crazydog335  | venture   |












