@api
Feature: API Automation Test

  @get-userlist @positive
  Scenario: Get List User
    Given prepare URL for get user
    When send GET request
    Then validate status code is 200
    And validate response with user list json schema

  @get-user @positive
  Scenario: Get Single User
    Given prepare URL for get single user
    And provide ID from list
    When send GET request
    Then validate status code is 200
    And validate response with single user json schema

  @get-user @negative
  Scenario: Get User by non exist ID
    Given prepare URL for get single user
    And provide random ID
    When send GET request
    Then validate status code is 400 or 404
    And validate response body contain error message "PARAMS_NOT_VALID"

  @create-user @positive
  Scenario: Create New User
    Given prepare URL for create user
    And provide user first name "Ardyan" and last name "Lawrence" and random email
    When send POST request
    Then validate status code is 200
    Then validate response body is containing same user data

  @create-user @negative
  Scenario: Create New User (Incomplete Data)
    Given prepare URL for create user
    And provide user first name "John" and last name "Pantau" and blank email
    When send POST request
    Then validate status code is 400 or 404
    Then validate response body contain error message "BODY_NOT_VALID"

  @delete-user @positive
  Scenario: Delete User
    Given prepare URL for delete user
    And provide user id from list
    When send DELETE request
    Then validate status code is 200
    Then validation response body delete user

  @delete-user @negatie
  Scenario: Delete Non Exist User
    Given prepare URL for delete user
    And provide user id from list
    When send DELETE request
    Then validate status code is 400 or 404
    Then response body berisi pesan error "PARAMS_NOT_VALID"




