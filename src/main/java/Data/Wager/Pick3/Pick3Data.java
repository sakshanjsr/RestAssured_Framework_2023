package Data.Wager.Pick3;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import utils.getProperties;

public class Pick3Data {
	
	public static JSONParser parser = new JSONParser();
	
	@Test
	public static JSONObject Pick3_QuickPick_Body_FromJSON() throws IOException, ParseException {
		
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Wager\\Pick3\\Pick3_QuickPick_Body.json");
		Object obj = parser.parse(reader);
		JSONObject jObject = (JSONObject)obj;
	       
	    return jObject;
		
	}
	
	@Test
	public static HashMap<String, String> Pick3_QuickPick_Headers_FromJSON(String token) throws IOException, ParseException {
		
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Wager\\Pick3\\Pick3_QuickPick_Headers.json");
		Object obj = parser.parse(reader);
		JSONObject jObject = (JSONObject)obj;
	       
	    HashMap<String, String> hm = new Gson().fromJson(jObject.toString(), HashMap.class);
	    
	    Properties props = getProperties.globalPorperties();
	    
	    for (Entry<String, String> ent : hm.entrySet()) {
	    	if(ent.getValue().contains("${")){
	    		String value = ent.getValue().substring(ent.getValue().indexOf("{") + 1, ent.getValue().indexOf("}"));
	    		hm.put(ent.getKey(), props.getProperty(value));
	    	}else 
	         if(ent.getValue().contains("%{oauthtoken}")) {
		    	 hm.put(ent.getKey(), " OAuth "+token);
	         }
	    }
	    
	    return hm;
		
	}

}
