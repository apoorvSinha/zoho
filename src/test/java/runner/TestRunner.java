package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
		dryRun=false,
		features={"./src/test/resources/features/"},
		glue="steps",
		monochrome=true,
		plugin={"pretty"}
		)

public class TestRunner {
	
}
