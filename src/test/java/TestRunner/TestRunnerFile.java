package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions", "Hooks"},
        monochrome = true,
        tags = "@Test",

        plugin = {"json:target/cucumber-reports/Cucumber.json",
                "pretty",
                "html:target/cucumber-reports/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)
public class TestRunnerFile extends AbstractTestNGCucumberTests {
}
