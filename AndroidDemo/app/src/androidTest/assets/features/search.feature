Feature: search
  Perform search after login

  @search-feature
  Scenario: Homepage
    Given I am on homepage
    And I search "Sa"
    And I choose "Sarah Scott"

