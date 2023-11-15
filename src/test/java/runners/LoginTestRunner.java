package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/Features/LoginTest.feature",glue={"StepDefinition"})
public class LoginTestRunner extends AbstractTestNGCucumberTests {
}
