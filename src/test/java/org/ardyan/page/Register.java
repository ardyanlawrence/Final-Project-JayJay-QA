package org.ardyan.page;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Register {
    WebDriver driver;
    WebDriverWait wait;

    By signUpModal = By.xpath("//*[@id=\"signInModal\"]");
    By usernameInput = By.id("sign-username");
    By passwordInput = By.id("sign-password");
    By signUpButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    public Register(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validateRegisterModalDisplayed() {
        driver.findElement(signUpModal).isDisplayed();
    }

    public void inputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void inputPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
}
