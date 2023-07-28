package utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Rest_Utils {
	
	private static RequestSpecification getRequestSpecification(String baseURL) {
		return  given()
				.baseUri(baseURL)
				.body("");

	}
	

	
	public static Response performGet (String baseURL) {
		
		RequestSpecification requestSpecifications = getRequestSpecification(baseURL);
		Response response = requestSpecifications.get();
		return response;
	}


}
