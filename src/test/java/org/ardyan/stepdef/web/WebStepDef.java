package org.ardyan.stepdef.web;

import io.cucumber.java.Scenario;
import org.ardyan.stepdef.CucumberHook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ardyan.BaseTest;
import org.ardyan.page.Home;
import org.ardyan.page.Login;
import org.ardyan.page.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebStepDef extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(WebStepDef.class);
    protected Home homePage;
    protected Register registerPage;
    protected Login loginPage;

    public WebStepDef() {
        this.homePage = new Home(driver, wait);
        this.registerPage = new Register(driver, wait);
        this.loginPage = new Login(driver, wait);
    }

    @Given("user is in homepage")
    public void userIsInHomepage() {
        homePage.goToHomePage();
    }

    @Then("user click menu sign up")
    public void userClickMenuSignUp() {
        homePage.clickSignUpButton();
    }


    @Then("verify register pop-up is displayed")
    public void verifyRegisterPopUpIsDisplayed() {
        registerPage.validateRegisterModalDisplayed();
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        Scenario currentScenario = CucumberHook.getCurrentScenario();
        if (currentScenario.getSourceTagNames().contains("@register")) {
            registerPage.inputUsername(username);
        } else {
            loginPage.inputUsername(username);
        }
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        Scenario currentScenario = CucumberHook.getCurrentScenario();
        if (currentScenario.getSourceTagNames().contains("@register")) {
            registerPage.inputPassword(password);
        } else {
            loginPage.inputPassword(password);
        }
    }

    @When("user click button sign up")
    public void userClickButtonSignUp() {
        registerPage.clickSignUpButton();
    }

    @Then("verify display alert message {string}")
    public void verifyDisplayAlertMessage(String alertMessage) {
        registerPage.validateErrorMessage(alertMessage);
    }

    @Then("user click menu login")
    public void userClickMenuLogin() {
        homePage.clickLoginButton();
    }

    @Then("verify login pop-up is displayed")
    public void verifyLoginPopUpIsDisplayed() {
        loginPage.validateLoginModalDisplayed();
    }

    @When("user click button login")
    public void userClickButtonLogin() {
        loginPage.clickLoginButton();
    }

    @Then("verify homepage with welcome user message")
    public void verifyHomepageWithWelcomeUserMessage() {
        loginPage.validateLoginSuccess();
    }

    @When("user clicks the logout button")
    public void userClicksTheLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Given("user is logged in with username {string} and password {string}")
    public void userIsLoggedInWithUsernameAndPassword(String username, String password) {
        if (!loginPage.validateLoginSuccess()) {
            homePage.clickLoginButton();
            loginPage.validateLoginModalDisplayed();
            loginPage.inputUsername(username);
            loginPage.inputPassword(password);
            loginPage.clickLoginButton();
            loginPage.validateLoginSuccess();
        }
    }

    @Then("verify user logged out")
    public void verifyUserLoggedOut() {
        homePage.validateLoggedOut();
    }
}
