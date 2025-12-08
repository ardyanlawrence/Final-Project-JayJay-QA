package org.ardyan.page;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;
    By signUpButton = By.xpath("//*[@id=\"signin2\"]");
    By loginButton = By.xpath("//*[@id=\"login2\"]");
    By contactButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By aboutButton = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By cartButton = By.xpath("//*[@id=\"cartur\"]");

    public Home(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToHomePage() {
        driver.get("https://www.demoblaze.com/");
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickContactButton() {
        driver.findElement(contactButton).click();
    }

    public void clickAboutUsButton() {
        driver.findElement(aboutButton).click();
    }

    public void clickCartButton() {
        driver.findElement(cartButton).click();
    }

    public void validateLoggedOut() {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        driver.findElement(loginButton).isDisplayed();
    }

    public void validateErrorMessage(String message) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            assert alert != null;
            Assert.assertEquals(alert.getText(), message);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert Not Showing");
        } catch (Exception e) {
            Assert.fail("Failed alert verification: " + e.getMessage());
        }
    }
}
