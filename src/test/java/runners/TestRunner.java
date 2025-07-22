package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features= {"src/test/java/features"},
	glue= {"hooks","stepDefinitions"},
	plugin= {"pretty","html:reports/cucumberreport.html"},
	dryRun=false
)
public class TestRunner {
	
}
