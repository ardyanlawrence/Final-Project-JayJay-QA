package org.ardyan.page;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
    WebDriver driver;
    WebDriverWait wait;

    By loginModal = By.xpath("//*[@id=\"logInModal\"]");
    By usernameInput = By.xpath("//*[@id=\"loginusername\"]");
    By passwordInput = By.xpath("//*[@id=\"loginpassword\"]");
    By loginButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By logoutButton = By.xpath("//*[@id=\"logout2\"]");
    By welcomeMenu = By.xpath("//*[@id=\"nameofuser\"]");

    public Login(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validateLoginModalDisplayed() {
        driver.findElement(loginModal).isDisplayed();
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean validateLoginSuccess() {
        try {
            return driver.findElement(welcomeMenu).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
}
