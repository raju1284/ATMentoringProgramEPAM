package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/Features/DashboardTest.feature",glue={"StepDefinition"})
public class DashboardTestRunner extends AbstractTestNGCucumberTests {
}
