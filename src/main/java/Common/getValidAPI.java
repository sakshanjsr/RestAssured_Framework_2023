package Common;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import utils.getProperties;

public class getValidAPI {
	
	public static String PROTOCOL ;
	public static String BASE_URL ;
	
	@Test
	public static void getAPI_valid() throws IOException {
		Properties props = getProperties.globalPorperties();
		PROTOCOL = props.getProperty("PROTOCOL");
		BASE_URL = props.getProperty("BASE_URL");	
		
	}

}
