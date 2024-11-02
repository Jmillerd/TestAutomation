Feature: Login feature

  Scenario Outline: Open website and check title
    Given I navigate to the website
    When I fill out the login form
    Then The submit button is displayed
    Examples:
    |username|password|
    |user1   |password1234!|
    |user2   |password1234!|
