package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Cart {
    WebDriver driver;
    WebDriverWait wait;
    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");

    public Cart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
