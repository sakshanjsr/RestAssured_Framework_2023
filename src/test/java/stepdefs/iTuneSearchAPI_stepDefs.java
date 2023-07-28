package stepdefs;

import java.io.IOException;

import Common.getResponse;
import Common.getValidAPI;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class iTuneSearchAPI_stepDefs {
	
	private int statusCode;
	
	@Given("User have a valid API")
	public void i_have_a_valid_api_endpoint() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	     getValidAPI.getAPI_valid();
	}

	@When("User send a GET request to Apple_iTune_API")
	public void i_send_a_get_request_to_apple_i_tune_api() throws IOException, ParseException {
	    // Write code here that turns the phrase above into concrete actions
		 statusCode = getResponse.getApiResponse();
	   
	}

	@Then("User gets the response status code should be {int}")
	public void the_response_status_code_should_be(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Status Code : "+statusCode);
	 
	}


}
