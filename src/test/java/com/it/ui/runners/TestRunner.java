package com.it.ui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;


@CucumberOptions(
        features = "src/test/resources/features/before-homepage.feature",
        glue = {"com.it.ui.teststeps","com.it.ui.hooks"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {

    }

}
