package Common;

import java.io.IOException;
import java.util.Properties;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import Data.Login.loginData;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import utils.Rest_Utils;
import utils.assertResponses;
import utils.getProperties;


public class Login {
	
	@Test
	public static String playerLogin() throws IOException, ParseException {
		
		
		Properties props = getProperties.globalPorperties(); 
		
		String CMD_PROTOCOL = props.getProperty("CMD_PROTOCOL");
		String CMD_URL = props.getProperty("CMD_URL");
		String oAuth_LOGIN = props.getProperty("oAuth_LOGIN");
		String baseURL=CMD_PROTOCOL + CMD_URL;
		
		Response Response = 
		Rest_Utils.performPost(baseURL , loginData.loginBodyFromJSON(), loginData.loginHeadersFromJSON() , oAuth_LOGIN);
                              // uri          payload                          header                     path parameter

		
		//JsonPath js = new JsonPath(Response);
		String body = Response.asString();
		System.out.println("Body : "+body);
		JsonPath jp = new JsonPath(body);
		String token = jp.getString("token[1]");
	    
		assertResponses.verifyStatusCode(Response.statusCode() , loginData.expectedResponsesFromJSON());
		assertResponses.verifyResponseTime(Response.time() , loginData.expectedResponsesFromJSON());
		assertResponses.verifyHeaders(Response.headers() , loginData.expectedResponsesFromJSON());
		assertResponses.verifyResponseBody(Response.body().toString(), loginData.expectedResponsesFromJSON());
		return token;
	}

}
