package org.ardyan;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"org.ardyan.stepdef.api"},
        features = {"src/test/resources"},
        plugin = {"pretty", "html:reports/api_reports.html", "json:reports/api_reports.json"},
        tags = "@api"
)

public class ApiTest {
}
