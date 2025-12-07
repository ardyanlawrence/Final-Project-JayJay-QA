package org.ardyan.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.ardyan.BaseTest;

public class CucumberHook extends BaseTest {
    private static final ThreadLocal<Scenario> currentScenario = new ThreadLocal<>();

    @Before
    public void beforeTest(Scenario scenario) {
        currentScenario.set(scenario);
        System.out.println("Starting Scenario: " + scenario.getName());
        if (scenario.getSourceTagNames().contains("@web")) {
            getDriver();
        }
    }

    @After
    public void afterTest(Scenario scenario) {
        System.out.println("Scenario " + scenario.getName() + " finished.");
        if (scenario.getSourceTagNames().contains("@web")) {
            driver.close();
        }
        currentScenario.remove();
    }

    public static Scenario getCurrentScenario() {
        return currentScenario.get();
    }
}