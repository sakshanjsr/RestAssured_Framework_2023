package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class getProperties {
	
	public static String environment = "Q1";
	
	public static Properties globalPorperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\global_"+environment+".properties");
		prop.load(file);
		return prop;
	}

}
