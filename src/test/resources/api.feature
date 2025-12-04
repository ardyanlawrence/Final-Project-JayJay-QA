@api
Feature: API Automation Test

  @get-userlist @positive
  Scenario: Get List User
    When send GET request for get list user
    Then validate status code is 200
    And validate response with json schema "user_list.json"

  @get-user @positive
  Scenario: Get Single User
    When send GET request for get single user with id "60d0fe4f5311236168a109f4"
    Then validate status code is 200
    And validate response with json schema "single_user.json"

  @get-user @negative
  Scenario: Get User by non exist ID
    When send GET request for get single user with id "1"
    Then validate status code is 400 or 401
    And validate response body contain error message "PARAMS_NOT_VALID"

  @create-user @positive
  Scenario: Create New User
    When send POST request for create user with "Ardyan" and last name "Lawrence" and random email
    Then validate status code is 200
    And validate response with json schema "single_user.json"

  @create-user @negative
  Scenario: Create New User (Incomplete Data)
    When send POST request for create user with "Lionel" and last name "Messi" and blank email
    Then validate status code is 400 or 404
    Then validate response body contain error message "BODY_NOT_VALID"

  @delete-user @positive
  Scenario: Delete User
    Given prepare URL for delete user
    And provide user id from list
    When send DELETE request
    Then validate status code is 200
    Then validation response body delete user

  @delete-user @negative
  Scenario: Delete Non Exist User
    Given prepare URL for delete user
    And provide user id from list
    When send DELETE request
    Then validate status code is 400 or 404
    Then response body berisi pesan error "PARAMS_NOT_VALID"




