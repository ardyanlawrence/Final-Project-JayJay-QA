# UI Automation - Cucumber, Java, Gradle, and Selenium
## Tujuan
PR 19 Module 21 - UI Automation Test pada web application Sauce Demo.
Project ini menggunakan teknik **Page Object Model (POM)** untuk memisahkan test logic dari setiap page.


## Framework yang digunakan

- **Cucumber**
- **Selenium**
- **Gradle**

## Persiapan

1. Clone repository.
2. Pastikan **Java** dan **Gradle** telah terinstal.
3. Jalankan perintah berikut untuk mengunduh dependensi:
   ```bash
   ./gradlew build 
4. Running Test, jalankan perintah 
    ```bash
    ./gradlew cucumber
5. Melakukan test yang hanya 1 di pilih: 
    ```bash
    ./gradlew cucumber -Ptags="@{tags}"
6. View report cucumber dengan format html: report/cucumber.html

### :zap: Struktur Project
    ├── src 
    │   └── test
    │       ├── java
    │       │   ├── org.ardyan
    │       │   ├── page                                # Page Object Models (POM)
    │       │   │   ├── Home.java
    │       │   │   └── Login.java
    │       │   ├── stepdef                             # Step Definitions
    │       │   │   ├── CucumberHooks.java
    │       │   │   ├── HomeStepDef.java
    │       │   │   ├── LoginStepDef.java
    │       │   └── BaseTest.java
    │       │   └── CucumberTest.java
    │       └── resources
    │           └── Login.feature                       # Gherkin File
    ├── .gitignore                                      # File untuk mengecualikan file tertentu dari git
    ├── build.gradle                                    # File konfigurasi Gradle
    ├── gradlew                                         
    ├── gradlew.bat                                     
    ├── settings.gradle                               
    └── README.md                                       