package Data.Login;

import java.awt.print.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import java.io.FileReader;

public class loginData {
	
	
	public static JSONParser parser = new JSONParser();
	
	
	
	public static HashMap<String, String> loginHeadersFromJSON() throws IOException, ParseException {

	       
	       FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Data\\Login\\loginHeaders.json");
	       Object obj = parser.parse(reader);
	       JSONObject jObject = (JSONObject)obj;
	       
	       HashMap<String, String> hm = new Gson().fromJson(jObject.toString(), HashMap.class);
	       return hm;	 
	       
	}
	
    
	public static JSONObject loginBodyFromJSON() throws IOException, ParseException {

		   java.io.FileReader reader = new java.io.FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\Data\\Login\\loginBody.json");
	       Object obj = parser.parse(reader);
	       JSONObject jObject = (JSONObject)obj;
	       
	       return jObject;
	}
	
	
	
}

