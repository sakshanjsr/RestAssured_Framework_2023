package stepdefs;

import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.Before;

public class hooks {
	
	public static String scenarioName;
	
	@Before
	public void beforeScenario(io.cucumber.java.Scenario scenario) {
		//extent = new ExtentReports (System.getProperty("user.dir") + \\test-output\\" + scenario.getName()+ ".html", true);
		scenarioName = scenario.getName();
		System.out.println("Name : "+scenarioName);
		
	}

}
