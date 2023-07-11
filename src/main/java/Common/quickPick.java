package Common;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.ParseException;

import Data.Login.loginData;
import Data.Wager.MegaMillion.MegaMillionData;
import Data.Wager.Pick3.Pick3Data;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Rest_Utils;
import utils.getProperties;

public class quickPick {

	
	public static void getQuickPick(String gameName , String token) throws IOException, ParseException {
	Properties props = getProperties.globalPorperties();
	String AWC_PROTOCOL = props.getProperty("AWC_PROTOCOL");
	String AWC_RANDOM_URL = props.getProperty("AWC_RANDOM_URL");
	String QUICK_PICK = props.getProperty("QUICK_PICK");
	String baseURL = AWC_PROTOCOL+AWC_RANDOM_URL;
	

	
	if(gameName.equalsIgnoreCase("MegaMillion")) {
		Response Response = 
				Rest_Utils.performPost(baseURL , MegaMillionData.MegaMillion_QuickPick_Body_FromJSON(), MegaMillionData.MegaMillion_QuickPick_Headers_FromJSON(token) , QUICK_PICK);
	
		String body = Response.asString();
		System.out.println("Body : "+body);

	}
	
	
	if(gameName.equalsIgnoreCase("Pick3")) {
		Response Response = 
				Rest_Utils.performPost(baseURL , Pick3Data.Pick3_QuickPick_Body_FromJSON(), Pick3Data.Pick3_QuickPick_Headers_FromJSON(token) , QUICK_PICK);
		String body = Response.asString();
		System.out.println("Body : "+body);
	
	   }
	}
	
}
