package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\priya.arora\\git\\careandmaintenance\\SSP_EC_Suite\\src\\main\\java\\Features",//the path of feature file
plugin={"pretty","html:test-output"},
glue={"step_def"},//the path of step def files
dryRun=false,
monochrome=true,// To display the console output in readable format.
strict=true //it will fail the execution if any steps are pending
)

public class TestRunner {
	
	

}
