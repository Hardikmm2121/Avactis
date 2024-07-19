package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigProp {

	private static Properties prop = new Properties();
		
	public static void loadProperties(String filePath) {
			
		try {
			prop.load(new FileInputStream(filePath));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static String getProperties(String value) {
		
		return prop.getProperty(value);
		
	}

}
