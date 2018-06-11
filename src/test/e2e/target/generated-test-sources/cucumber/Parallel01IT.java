import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
features = {"C:/Users/Janaki.Kamat/Automation_testing/CucumberProjects/selenium-samples-java/custom-tech-test/src/test/resources/features/TestTech.feature"},
plugin = {"json:target/custom-tech-test/1.json", "html:target/custom-tech-test/1.html"},
monochrome = false,
 tags = {"~@ignored"}, glue = { "step_definitions" })
public class Parallel01IT {
}
