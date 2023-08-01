package runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepdefs"},
		plugin = {"pretty" , "html:target/cucumber-report.html" , "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@Regression",
		monochrome = true
	)


public class TestRunner extends AbstractTestNGCucumberTests{

//	  @DataProvider(parallel = true)
//	    @Override
//	    public Object[][] scenarios() {
//	        return super.scenarios();
//	    }

}
