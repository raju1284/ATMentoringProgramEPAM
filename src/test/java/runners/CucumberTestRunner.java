package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(tags="@Test1",features="src/test/resources/Features/api/DashbaordAPI.feature",glue={"StepDefinition"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
