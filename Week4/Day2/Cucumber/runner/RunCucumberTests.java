package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Login.feature",
					glue = "steps",
					publish = true, monochrome = true,
					dryRun = false)
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
