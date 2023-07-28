package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepdefs"},
		plugin = {"pretty" , "html:target/cucumber-report.html"},
		tags = "@Smoke",
		monochrome = true
	)


public class TestRunner extends AbstractTestNGCucumberTests{

}
