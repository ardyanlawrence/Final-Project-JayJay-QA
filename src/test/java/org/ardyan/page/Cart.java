package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Cart {
    WebDriver driver;
    WebDriverWait wait;
    By totalPrice = By.xpath("//*[@id=\"totalp\"]");
    By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By purchaseButton = By.cssSelector("button[onclick='purchaseOrder()']");
    By closeButton = By.xpath("//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']");
    By xButton = By.xpath("//div[@id='orderModal']//span[@aria-hidden='true']");
    By orderModal = By.xpath("//*[@id=\"orderModal\"]/div/div");
    By nameForm = By.id("name");
    By countryForm = By.id("country");
    By cityForm = By.id("city");
    By creditCardForm = By.id("card");
    By monthForm = By.id("month");
    By yearForm = By.id("year");
    By orderSuccessModal = By.xpath("/html/body/div[10]");
    By okSuccessOrderButton = By.xpath("//button[normalize-space()='OK']");

    By item_name(String itemName) {
        return By.xpath("//tr[@class='success'] //child:: td[normalize-space()='" + itemName + "']");
    }

    public Cart(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void verifyProductAddedToCart(String itemAddedName) {
        String[] itemAddedArray = itemAddedName.split(", ");
        for (String item : itemAddedArray) {
            WebElement cartItem = driver.findElement(item_name(item));
            assertTrue(cartItem.isDisplayed());
        }
    }

    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void verifyTotalPriceDisplay() {
        driver.findElement(totalPrice).isDisplayed();
    }

    public void verifyOrderModalDisplayed() {
        driver.findElement(orderModal).isDisplayed();
    }

    public void inputName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameForm));
        driver.findElement(nameForm).sendKeys(name);
    }

    public void inputCountry(String country) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(countryForm));
        driver.findElement(countryForm).sendKeys(country);
    }

    public void inputCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityForm));
        driver.findElement(cityForm).sendKeys(city);
    }

    public void inputCreditCard(String card) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(creditCardForm));
        driver.findElement(creditCardForm).sendKeys(card);
    }

    public void inputMonth(String month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthForm));
        driver.findElement(monthForm).sendKeys(month);
    }

    public void inputYear(String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearForm));
        driver.findElement(yearForm).sendKeys(year);
    }

    public void clickPurchaseButton(){
        driver.findElement(purchaseButton).click();
    }

    public void verifyOrderSuccessModalDisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(orderSuccessModal));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessModal));
        driver.findElement(orderSuccessModal).isDisplayed();
    }

    public void clickOkSuccessButton(){
        driver.findElement(okSuccessOrderButton).click();
    }
}
