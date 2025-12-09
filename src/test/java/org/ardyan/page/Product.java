package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
    WebDriver driver;
    WebDriverWait wait;
    By addToCartButton = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");

    public Product(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
}
