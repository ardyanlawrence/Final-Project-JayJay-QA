package org.ardyan;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected void getDriver() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // Disables "Offer to save passwords"
        prefs.put("profile.password_manager_enabled", false); // Disables the password manager itself
        prefs.put("profile.password_manager_leak_detection", false); // Disables password leak detection warnings

        // Set the preferences in ChromeOptions
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
