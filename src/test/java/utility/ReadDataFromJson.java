package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	
	public ArrayList<String> readDataFromJson() throws IOException, ParseException {
		
		JSONParser jparser = new JSONParser(); 
		
		FileReader reader = new FileReader("src/test/resources/testdata/searchdata.json");
		
		Object obj = jparser.parse(reader);
		
		JSONObject jo = (JSONObject)obj;
		
		JSONArray ja = (JSONArray)jo.get("searchitem");
					
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i<ja.size(); i++) {
			
			String value = (String)ja.get(i);
			list.add(value);
		}
		 return list;
	}
}
	
