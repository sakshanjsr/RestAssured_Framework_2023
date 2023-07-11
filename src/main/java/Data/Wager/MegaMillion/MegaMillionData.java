package Data.Wager.MegaMillion;


import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.commons.codec.binary.StringUtils;
import org.codehaus.groovy.util.StringUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import utils.getProperties;



public class MegaMillionData {
	
	public static JSONParser parser = new JSONParser();
	
	@Test
	public static JSONObject MegaMillion_QuickPick_Body_FromJSON() throws IOException, ParseException {
		
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Wager\\MegaMillion\\MM_QuickPick_Body.json");
		Object obj = parser.parse(reader);
		JSONObject jObject = (JSONObject)obj;
	       
        System.out.println(jObject);
	    return jObject;
		
	}
	
	@Test
	public static HashMap<String, String> MegaMillion_QuickPick_Headers_FromJSON(String token) throws IOException, ParseException {
		
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\Data\\Wager\\MegaMillion\\MM_QuickPick_Headers.json");
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
	    
	    System.out.println("MM Data Headers: "+hm);
	    return hm;
		
	}

}
