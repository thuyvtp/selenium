package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions (features ="src/test/java/features",
plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-  report.json"},
monochrome = true,
glue={"stepDefinitions"})
public class CucumberRunner extends AbstractTestNGCucumberTests{
}



