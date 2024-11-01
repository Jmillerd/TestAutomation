package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    @Test
    public void runCucumberTests() {
        // This method triggers the Cucumber tests
    }
}
