package runner_files;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = {"src/test/resources/feature_files"},
		glue = {"src/test/java/step_definition_files"},
		tags = "@tutorialsNinja"
		
		
		
		)

public class Runner_TestNG extends AbstractTestNGCucumberTests {
	
	

	
}
