package Common;

import java.io.IOException;

import org.testng.annotations.Test;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.ParseException;
import io.restassured.response.Response;
import utils.Rest_Utils;

public class getResponse extends getValidAPI{
	
	
	
	@Test
	public static int getApiResponse() throws IOException, ParseException {
		
		String url = PROTOCOL+BASE_URL;

		Response res = Rest_Utils.performGet(url);
		
	

		int statusCode = res.getStatusCode();
		return statusCode;
		
		
	}

}
