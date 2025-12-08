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

  @contact
  Scenario: User can successfully send message
    Given user is in homepage
    Then user click menu contact us
    Then verify contact pop-up is displayed
    And user input email with "ardyanlawrence6@gmail.com"
    And user input name with "Ardyan"
    And user input message "Barangnya mahal-mahal"
    When user click send message button
    Then verify display alert message "Thanks for the message!!"

  @contact
  Scenario: User can close contact modal using close button
    Given user is in homepage
    Then user click menu contact us
    Then verify contact pop-up is displayed
    When user click close button
    Then verify contact pop-up is not displayed

  @contact
  Scenario: User can close contact modal using X button
    Given user is in homepage
    Then user click menu contact us
    Then verify contact pop-up is displayed
    When user click X button
    Then verify contact pop-up is not displayed

  @checkout
  Scenario: User can successfully checkout 1 Product
    Given user is in homepage
    Then user is logged in with username "ardyanlawrence6" and password "gu4c4k3p"
    And user click product "Samsung galaxy s6"
    And user click add to cart
    And verify display alert message "Product added"
    And user go to cart menu
    And verify product should be added in the cart page "Samsung galaxy s6"
    And verify user can see total price
    And user click place order button
    And verify order form pop-up will be displayed
    And user input name "hanif"
    And user input country "hanif"
    And user input city "hanif"
    And user input credit card "hanif"
    And user input month "hanif"
    And user input year "hanif"
    And user click purchase button
    Then user see the pop-up successfully order
    And user click OK button on the pop-up successfully order

