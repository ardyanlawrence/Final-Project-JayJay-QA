package org.ardyan.stepdef.web;

import io.cucumber.java.Scenario;
import org.ardyan.page.*;
import org.ardyan.stepdef.CucumberHook;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ardyan.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebStepDef extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(WebStepDef.class);
    protected Home homePage;
    protected Register registerPage;
    protected Login loginPage;
    protected Contact contactPage;
    protected About aboutPage;
    protected Cart cartPage;
    protected Product productPage;

    public WebStepDef() {
        this.homePage = new Home(driver, wait);
        this.registerPage = new Register(driver, wait);
        this.loginPage = new Login(driver, wait);
        this.contactPage = new Contact(driver, wait);
        this.aboutPage = new About(driver, wait);
        this.cartPage = new Cart(driver, wait);
        this.productPage = new Product(driver, wait);
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
        } else if (currentScenario.getSourceTagNames().contains("@login")) {
            loginPage.inputUsername(username);
        }
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        Scenario currentScenario = CucumberHook.getCurrentScenario();
        if (currentScenario.getSourceTagNames().contains("@register")) {
            registerPage.inputPassword(password);
        } else if (currentScenario.getSourceTagNames().contains("@login")) {
            loginPage.inputPassword(password);
        }
    }

    @When("user click button sign up")
    public void userClickButtonSignUp() {
        registerPage.clickSignUpButton();
    }

    @Then("verify display alert message {string}")
    public void verifyDisplayAlertMessage(String alertMessage) {
        homePage.validateErrorMessage(alertMessage);
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

    @Then("user click menu contact us")
    public void userClickMenuContactUs() {
        homePage.clickContactButton();
    }

    @Then("verify contact pop-up is displayed")
    public void verifyContactPopUpIsDisplayed() {
        contactPage.validateContactModalDisplayed();
    }

    @And("user input email with {string}")
    public void userInputEmailWith(String email) {
        contactPage.inputContactEmail(email);
    }

    @And("user input name with {string}")
    public void userInputNameWith(String name) {
        contactPage.inputContactName(name);
    }

    @And("user input message {string}")
    public void userInputMessage(String message) {
        contactPage.inputMessage(message);
    }

    @When("user click send message button")
    public void userClickSendMessageButton() {
        contactPage.clickSendMessageButton();
    }

    @When("user click close button")
    public void userClickCloseButton() {
        Scenario currentScenario = CucumberHook.getCurrentScenario();
        if (currentScenario.getSourceTagNames().contains("@contact")) {
            contactPage.clickCloseButton();
        } else if (currentScenario.getSourceTagNames().contains("@aboutus")) {
            aboutPage.clickCloseButton();
        }
    }

    @When("user click X button")
    public void userClickXButton() {
        Scenario currentScenario = CucumberHook.getCurrentScenario();
        if (currentScenario.getSourceTagNames().contains("@contact")) {
            contactPage.clickXButton();
        } else if (currentScenario.getSourceTagNames().contains("@aboutus")) {
            aboutPage.clickXButton();
        }
    }

    @Then("verify contact pop-up is not displayed")
    public void verifyContactPopUpIsNotDisplayed() {
        contactPage.verifyContactModalNotDisplayed();
    }

    @Then("user click menu about us")
    public void userClickMenuAboutUs() {
        homePage.clickAboutUsButton();
    }

    @And("verify about us pop-up is displayed")
    public void verifyAboutUsPopUpIsDisplayed() {
        aboutPage.validateAboutModalDisplayed();
    }

    @Then("verify about us pop-up is not displayed")
    public void verifyAboutUsPopUpIsNotDisplayed() {
        aboutPage.validateAboutModalNotDisplayed();
    }

    @When("user click button play video")
    public void userClickButtonPlayVideo() {
        aboutPage.clickPlayButton();
    }

    @Then("verify the video is played")
    public void verifyTheVideoIsPlayed() {
        aboutPage.validateVideoPlayed();
    }

    @And("user click menu cart")
    public void userClickMenuCart() {
        homePage.clickCartButton();
    }

    @And("user click product {string}")
    public void userClickProduct(String product) throws InterruptedException {
        Thread.sleep(2000);
        homePage.clickProduct(product);
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @And("verify product {string} is in the cart")
    public void verifyProductIsInTheCart(String product) throws InterruptedException {
        Thread.sleep(2000);
        cartPage.verifyProductAddedToCart(product);
    }

    @And("verify user can see total price")
    public void verifyUserCanSeeTotalPrice() {
        cartPage.verifyTotalPriceDisplay();
    }

    @And("user click place order button")
    public void userClickPlaceOrderButton() {
        cartPage.clickPlaceOrderButton();
    }


    @And("verify order form pop-up is displayed")
    public void verifyOrderFormPopUpIsDisplayed() {
        cartPage.verifyOrderModalDisplayed();
    }

    @And("user input name {string}")
    public void userInputName(String name) {
        cartPage.inputName(name);
    }

    @And("user input country {string}")
    public void userInputCountry(String country) {
        cartPage.inputCountry(country);
    }

    @And("user input city {string}")
    public void userInputCity(String city) {
        cartPage.inputCity(city);
    }

    @And("user input credit card {string}")
    public void userInputCreditCard(String card) {
        cartPage.inputCreditCard(card);
    }

    @And("user input month {string}")
    public void userInputMonth(String month) {
        cartPage.inputMonth(month);
    }

    @And("user input year {string}")
    public void userInputYear(String year) {
        cartPage.inputYear(year);
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
        cartPage.clickPurchaseButton();
    }

    @Then("user see the pop-up successfully order")
    public void userSeeThePopUpSuccessfullyOrder() {
        cartPage.verifyOrderSuccessModalDisplayed();
    }

    @And("user click OK button on the pop-up successfully order")
    public void userClickOKButtonOnThePopUpSuccessfullyOrder() {
        cartPage.clickOkSuccessButton();
    }
}
