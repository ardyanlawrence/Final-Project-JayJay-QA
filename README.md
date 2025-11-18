# API & UI Automation
Final Project JayJay QA Bootcamp

## ✅ Test Cases
### API Automation
This project covers automated test scenarios for the following core features of [dummyapi.io](https://dummyapi.io/docs):

### 👤 User API
| Test Case                         | Type     | Description                                                                |
|-----------------------------------|----------|----------------------------------------------------------------------------|
| Get List User                     | Positive | Validates Successful user list retrieval                                   |
| Get Single User                   | Positive | Validate successful single user retrieval                                  |
| Get User by non exist ID          | Negative | Validates API return error when requesting a user with not exist ID        |
| Create New user                   | Positive | Validates Create User                                                      |
| Create New User (Incomplete Data) | Negative | Validate API return error when create user with incomplete data (no email) |
| Delete user                       | Positive | Validates Delete User Process                                              |
| Delete non exist user             | Negative | Validate API return error when deleting non exist user                     |


Each test cases for API Automation Test is written using **Gherkin** and executed with **TestNG**