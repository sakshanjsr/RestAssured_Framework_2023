package utils;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.common.collect.Multiset.Entry;
import com.google.gson.Gson;

import Data.Login.loginData;
import io.restassured.http.*;
import io.restassured.path.json.JsonPath;

public class assertResponses {
	

	
	public static void verifyHeaders(Headers responseHeaders , JSONObject expectedResponseData) throws IOException, ParseException {
		
		//JsonPath jp = new JsonPath(expectedResponseData.toString());
		//String headers = jp.getString("headers");
		HashMap<String, String> expectedResponseHeaders = new Gson().fromJson(expectedResponseData.get("headers").toString(), HashMap.class);
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Response Headers : "+responseHeaders);
		System.out.println("Expected Headers : "+expectedResponseHeaders);
		System.out.println("-----------------------------------------------------------------");
		
		
		for(java.util.Map.Entry<String, String> e : expectedResponseHeaders.entrySet()) {
			
			System.out.println(e.getKey() + " : "+e.getValue());
			System.out.println("Response Header : "+responseHeaders.getValue(e.getKey()));
			
			
			if(responseHeaders.getValue(e.getKey()) != null) {
				if(responseHeaders.getValue(e.getKey()).equals(e.getValue())) {
					System.out.println(e.getKey() + " header verified");
				}else {
					System.out.println(e.getKey() + " header mismatch");
					ExtentReporterNG.logFailDetails("Header Mismatch "+e.getKey());
				}
			}else {
				System.out.println(e.getKey() + " is null");
			}
			
		}
		
	}
	
	
	public static void verifyStatusCode(int actualStatusCode , JSONObject expectedResponseData) {
		JsonPath jp = new JsonPath(expectedResponseData.toString());
		int expecteStatusCode = Integer.parseInt(jp.getString("statusCode"));
		
		if(actualStatusCode == expecteStatusCode) {
			ExtentReporterNG.logPassDetails("Status Code Matched : "+"\n Actual Status Code : "+actualStatusCode +"\n Expected Status Code : "+expecteStatusCode);
		}else {
			System.out.println("Status Code Mismatch");
			ExtentReporterNG.logFailDetails("Status Code Mismatch : "+"\n Actual Status Code : "+actualStatusCode +"\n Expected Status Code : "+expecteStatusCode);
		}
	}
	
	
	public static void verifyResponseTime(long actualResponseTime , JSONObject expectedResponseData) {
		JsonPath jp = new JsonPath(expectedResponseData.toString());
		int expecteResponseTime = Integer.parseInt(jp.getString("responseTime"));
		
		if(actualResponseTime <= expecteResponseTime) {
			System.out.println("Expected Response Time");
			ExtentReporterNG.logPassDetails("Response Time Passed : "+"\n Actual Response Time : "+actualResponseTime +"\n Expected Response Time : "+expecteResponseTime);
		}else {
			System.out.println("Response Time Mismatch");
			ExtentReporterNG.logWarningDetails("Response Time Mismatch : "+"\n Actual Response Time : "+actualResponseTime +"\n Expected Response Time : "+expecteResponseTime);
		}
	}
	
	
	public static void verifyResponseBody(String actualResponseBody , JSONObject expectedResponseData) {
		
		HashMap<String, String> expectedResponseBody = new Gson().fromJson(expectedResponseData.get("body").toString(), HashMap.class);
		System.out.println("expectedResponseBody : "+expectedResponseBody  );
	}

}
