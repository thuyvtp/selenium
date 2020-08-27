Feature: Login


  Scenario: Login seller center
    Given user open login page
    When user click on button login 
    And  user input correct email
    And user input correct password

    Then Verify user login success

