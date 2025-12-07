package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    WebDriver driver;
    WebDriverWait wait;
    By signUpButton = By.xpath("//*[@id=\"signin2\"]");
    By loginButton = By.xpath("//*[@id=\"login2\"]");
    By logoutButton = By.xpath("//*[@id=\"logout2\"]");


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


    public void validateLoggedOut() {
        wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        driver.findElement(loginButton).isDisplayed();
    }
}
