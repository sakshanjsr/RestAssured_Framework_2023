package Common;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class getAccountBalance {
	
		
		private static HashMap<String, String> headersData(String token){
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("Connection" , "keep-alive");
			hm.put("Authorization" , "OAuth "+token);
			hm.put("Accept" , "*/*");
			return hm;
			}
		
	
		public static int getAccountBalanceOfPlayer(String token) {
			RestAssured.baseURI="https://cmdsecgateway-rnd-lot-cmd-d2-northeurope.igtilotterycmdtest.com/";
			String accountDetails = 
			given().headers(headersData(token))
			.when().get("api/v2/players/self/account")
			.then().assertThat().statusCode(200).extract().response().body().prettyPrint().toString();
			
			JsonPath js = new JsonPath(accountDetails);
			int accountBalance = js.getInt("balances.default.balance");
			System.out.println("Account Balance : "+accountBalance);
			return accountBalance;
		}

	

}
