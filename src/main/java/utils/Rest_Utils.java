package utils;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class Rest_Utils {
	
	private static RequestSpecification getRequestSpecification(String baseURL, JSONObject payLoad , HashMap<String, String>headers) {
		return  given()
				.baseUri(baseURL)
				.headers(headers)
				.body(payLoad);
	}
	
	private static void printRequestLogInReport(RequestSpecification requestSpecification) {
		QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
		ExtentReporterNG.logInfoDetails("Base URL is : " + queryableRequestSpecification.getBaseUri());
		ExtentReporterNG.logInfoDetails("API Method is : " + queryableRequestSpecification.getMethod());
		ExtentReporterNG.logInfoDetails("Request Headers are : " + queryableRequestSpecification.getHeaders().asList());
		ExtentReporterNG.logHeaders(queryableRequestSpecification.getHeaders().asList());
		ExtentReporterNG.logInfoDetails("Request body is : ");
		ExtentReporterNG.logInfo(queryableRequestSpecification.getBody());
	}
	
	private static void printResponseLogInReport(Response response) {
		ExtentReporterNG.logInfoDetails("Response Status Code is : " + response.getStatusCode());
		ExtentReporterNG.logInfoDetails("Response Headers are : ");
		ExtentReporterNG.logHeaders(response.getHeaders().asList());
		ExtentReporterNG.logInfoDetails("Response Body is : ");
		ExtentReporterNG.logInfo(response.getBody().prettyPrint());
	}
	
	public static Response performPost (String baseURL, JSONObject payLoad , HashMap<String, String> headers ,String path) {
		
		RequestSpecification requestSpecifications = getRequestSpecification( baseURL,  payLoad , headers);
		Response response = requestSpecifications.post(path);
		printRequestLogInReport(requestSpecifications);
		printResponseLogInReport(response);
		return response;
	}
	
	public static Response performGet (String baseURL, JSONObject payLoad , HashMap<String, String> headers ,String path) {
		
		RequestSpecification requestSpecifications = getRequestSpecification( baseURL,  payLoad , headers);
		Response response = requestSpecifications.get(path);
		printRequestLogInReport(requestSpecifications);
		printResponseLogInReport(response);
		return response;
	}

	public static Response performPut (String baseURL, JSONObject payLoad , HashMap<String, String> headers ,String path) {
		
		RequestSpecification requestSpecifications = getRequestSpecification( baseURL,  payLoad , headers);
		Response response = requestSpecifications.put(path);
		printRequestLogInReport(requestSpecifications);
		printResponseLogInReport(response);
		return response;
	}


}
