@web
Feature: UI Automation Testing Demoblaze

  @register @positive
  Scenario: Register User
    Given user is in homepage
    Then user click menu sign up
    Then verify register pop-up is displayed
    And user input username with "lionelmessi10"
    And user input password with "gu4c4k3p"
    When user click button sign up
    Then verify display alert message "Sign up successful."

  @register @negative
  Scenario: Register without Username
    Given user is in homepage
    Then user click menu sign up
    Then verify register pop-up is displayed
    And user input username with ""
    And user input password with "g4nt3ngb4n63t"
    When user click button sign up
    Then verify display alert message "Please fill out Username and Password."

  @register @negative
  Scenario: Register without Password
    Given user is in homepage
    Then user click menu sign up
    Then verify register pop-up is displayed
    And user input username with ""
    And user input password with "c4k3pb4n63t"
    When user click button sign up
    Then verify display alert message "Please fill out Username and Password."

  @register @negative
  Scenario: Register without Username & Password
    Given user is in homepage
    Then user click menu sign up
    Then verify register pop-up is displayed
    And user input username with ""
    And user input password with ""
    When user click button sign up
    Then verify display alert message "Please fill out Username and Password."

  @login @positive
  Scenario: Login using valid username and password
    Given user is in homepage
    Then user click menu login
    Then verify login pop-up is displayed
    And user input username with "ardyanlawrence6"
    And user input password with "gu4c4k3p"
    When user click button login
    Then verify homepage with welcome user message

  @login @negative
  Scenario: Login using wrong password
    Given user is in homepage
    Then user click menu login
    Then verify login pop-up is displayed
    And user input username with ""
    And user input password with ""
    When user click button login
    Then verify display alert message "Please fill out Username and Password."

  @login @negative
  Scenario: Login using empty username & password
    Given user is in homepage
    Then user click menu login
    Then verify login pop-up is displayed
    And user input username with ""
    And user input password with ""
    When user click button login
    Then verify display alert message "Please fill out Username and Password."

  @logout
  Scenario: User can successfully logout
    Given user is in homepage
    Then user is logged in with username "ardyanlawrence6" and password "gu4c4k3p"
    When user clicks the logout button
    Then verify user logged out