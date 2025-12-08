package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Contact {
    WebDriver driver;
    WebDriverWait wait;
    By contactModal = By.xpath("//*[@id=\"exampleModal\"]");
    By contactEmailInput = By.xpath("//*[@id=\"recipient-email\"]");
    By contactNameInput = By.xpath("//*[@id=\"recipient-name\"]");
    By messageInput = By.xpath("//*[@id=\"message-text\"]");
    By sendMessageButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
    By closeButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");
    By xButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/button/span");

    public Contact(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validateContactModalDisplayed() {
        driver.findElement(contactModal).isDisplayed();
    }

    public void inputContactEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactEmailInput));
        driver.findElement(contactEmailInput).sendKeys(email);
    }

    public void inputContactName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameInput));
        driver.findElement(contactNameInput).sendKeys(name);
    }

    public void inputMessage(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(messageInput));
        driver.findElement(messageInput).sendKeys(message);
    }

    public void clickSendMessageButton() {
        driver.findElement(sendMessageButton).click();
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        driver.findElement(closeButton).click();
    }

    public void clickXButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xButton));
        driver.findElement(xButton).click();
    }

    public void verifyContactModalNotDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(contactModal));
        assertFalse(driver.findElement(contactModal).isDisplayed());
    }
}
