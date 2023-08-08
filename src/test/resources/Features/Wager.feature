Feature: Place Wagers for different games

  @Smoke
  Scenario: Place PICK3 Wager
    Given User is logged into the Application
    And User gets the current account balance
    When User gets the "Pick3" QuickPick
    Then Place PICK3 Wager

  @Regression
  Scenario Outline: Place All Games Wager
    Given User is logged into the Application
    And User gets the current account balance
    When User gets the "<GameName>" QuickPick
    Then Place PICK3 Wager
     

    Examples: 
      | GameName    |
      | Pick3       |
      | MegaMillion |
