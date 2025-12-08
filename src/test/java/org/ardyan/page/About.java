package org.ardyan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class About {
    WebDriver driver;
    WebDriverWait wait;
    By aboutModal = By.xpath("//*[@id=\"videoModal\"]");
    By closeButton = By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button");
    By xButton = By.xpath("//*[@id=\"videoModal\"]/div/div/div[1]/button/span");
    By playButton = By.xpath("//*[@id=\"example-video\"]/button");
    By videoPlayed = By.xpath("//button[@class='vjs-play-control vjs-control vjs-button vjs-playing']");

    public About(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void validateAboutModalDisplayed() {
        driver.findElement(aboutModal).isDisplayed();
    }

    public void clickXButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xButton));
        driver.findElement(xButton).click();
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton));
        driver.findElement(closeButton).click();
    }

    public void clickPlayButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
        driver.findElement(playButton).click();
    }

    public void validateAboutModalNotDisplayed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(aboutModal));
        assertFalse(driver.findElement(aboutModal).isDisplayed());
    }

    public void validateVideoPlayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(videoPlayed));
        driver.findElement(videoPlayed).isDisplayed();
    }
}
