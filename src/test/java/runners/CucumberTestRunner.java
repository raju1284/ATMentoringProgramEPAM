package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/Features",glue={"StepDefinition"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
