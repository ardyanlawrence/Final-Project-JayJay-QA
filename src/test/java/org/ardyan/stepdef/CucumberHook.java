package org.ardyan.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.ardyan.BaseTest;

public class CucumberHook extends BaseTest {
    @Before("@api")
    public void beforeTest(Scenario scenario) {
        System.out.println("Starting Scenario: " + scenario.getName());
        getDriver();
    }

    @After("@api")
    public void afterTest(Scenario scenario) {
        System.out.println("Scenario " + scenario.getName() + " finished.");
    }
}
