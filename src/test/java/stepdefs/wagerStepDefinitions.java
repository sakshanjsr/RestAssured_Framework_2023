package stepdefs;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Common.Login;
import Common.getAccountBalance;
import Common.quickPick;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class wagerStepDefinitions {

	private String token;
	

	@Given("User is logged into the Application")
	public void user_is_logged_into_the_application() throws IOException, ParseException {
	    // Write code here that turns the phrase above into concrete actions
		 token = Login.playerLogin();
	}

	@Given("User gets the current account balance")
	public void user_gets_the_current_account_balance() {
	    // Write code here that turns the phrase above into concrete actions
		getAccountBalance.getAccountBalanceOfPlayer(token);
	}

	
	@When("User gets the {string} QuickPick")
	public void user_gets_the_quick_pick(String gameName) throws IOException, ParseException {
	    // Write code here that turns the phrase above into concrete actions
		quickPick.getQuickPick(gameName, token);
	}

	@Then("Place PICK3 Wager")
	public void place_pick3_wager() {
	    // Write code here that turns the phrase above into concrete actions
	}


}
