# API & UI Automation
Final Project JayJay QA Bootcamp

## ✅ Test Cases
### API Automation
This project covers automated test scenarios for the following core features of [dummyapi.io](https://dummyapi.io/docs):

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

### WEB UI Automation
This project covers automated test scenarios for the following features of [demoblaze.com](https://dummyapi.io/docs):

| Test Case                                       | Type     | Description                              |
|-------------------------------------------------|----------|------------------------------------------|
| Register User                                   | Positive | Validates Successful user list retrieval |
| Register without Username                       | Negative | Validates username requirement           |
| Register without Password                       | Negative | Validates password requirement           |
| Register without Username & Password            | Negative | Validates required field alert           |
| Login using valid username and password         | Positive | Validates successful login flow          |
| Login using wrong password                      | Negative | Validates incorrect credentials handling |
| Login using empty username & password           | Negative | Validates required field alert           |
| User can successfully logout                    | Positive | Validates logout functionality           |
| User can successfully send message              | Positive | Validates successful send message        |
| User can close contact modal using X button     | Positive | Validates close modal using X button     |
| User can close contact modal using close button | Positive | Validates close modal using Close Button |
| User can play video on the about us pop-up      | Positive | Validates video successfully played      |
| User can close contact modal using X button     | Positive | Validates close modal using X button     |
| User can close contact modal using close button | Positive | Validates close modal using Close Button |
| User can successfully checkout 1 Product        | Positive | Validates successfully checkout flow     |

Each scenario is written using **Gherkin syntax** and executed with **Selenium & TestNG**
You can find the complete step definitions and page interactions in the corresponding test classes.

## 🛠 Technologies Used

- Java
- Selenium
- Rest Assured
- TestNG
- Gradle
- Cucumber
- Github Actions

<img src="https://skillicons.dev/icons?i=java,idea,selenium,gradle,gherkin,git,github" alt=""/>

### 📁 Project Structure
    │── src 
    │   └── test
    │       ├── java
    │       │   ├── org.ardyan
    │       │   │   ├── helper                                               
    │       │   │   │   ├── Endpoint.java
    │       │   │   │   └── Utilities.java
    │       │   │   ├── JSONSchema
    │       │   │   │   ├── single_user.json
    │       │   │   │   └── user_list.json
    │       │   │   ├── model
    │       │   │   │   └── ApiModel.java
    │       │   │   ├── pages                                            # Page Object Models (POM)
    │       │   │   │   ├── About.java                        
    │       │   │   │   ├── Cart.java                        
    │       │   │   │   ├── Contact.java                        
    │       │   │   │   ├── Home.java                        
    │       │   │   │   ├── Login.java       
    │       │   │   │   ├── Product.java
    │       │   │   │   └── Register.java                        
    │       │   │   ├── stepdef                                         # Step Definitions API & WEB
    │       │   │   │   ├── api
    │       │   │   │   │   └── ApiStepDef.java                        
    │       │   │   │   ├── web
    │       │   │   │   │   └── WebStepDef.java                        
    │       │   │   │   └── CucumberHook.java
    │       │   │   ├── ApiTest.java
    │       │   │   ├── WebTest.java                        
    │       └── resources
    │           └── api.feature                                         # Feature Files API
    │           └── web.feature                                         # Feature Files WEB
    ├── .gitignore                                                      
    ├── build.gradle                                                    
    ├── gradlew                                                         
    ├── gradlew.bat                                                    
    ├── config.properties                                               
    └── README.md                                                       

## ⚙️ Setup & Installation

Follow the steps below to set up and run the project locally:

### 1. Clone the Repository

```bash
git clone https://github.com/ardyanlawrence/Final-Project-JayJay-QA.git
cd Final-Project-JayJay-QA
```

### 2. Open in Your IDE

- Open the project folder using your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).
- Make sure Java JDK (version 8 or higher) is installed and configured.
- Import the project as a Gradle project

### 3. Install Dependencies

run the following command to download dependencies:

```bash
gradle build
```
### 4. Run the Tests

✅ Run Web Tests
```bash
./gradlew web
```
✅ Run API Tests
```bash
./gradlew api
```

### Reports
API Reports [API Reports](https://ardyanlawrence.github.io/Final-Project-JayJay-QA/api_reports.html)

WEB Reports [WEB Reports](https://ardyanlawrence.github.io/Final-Project-JayJay-QA/web_reports.html)
## Acknowledgments
This project was developed as Final Project of the QA Engineer Online Course by JayJay.  
Thanks to the creators of demoblaze.com and dummyapi.io for providing the demo site.