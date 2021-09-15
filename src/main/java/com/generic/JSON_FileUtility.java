package com.generic;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_FileUtility {
	/**
	 * @author Satyajeet
	 * This method is used to read data from JSON file
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String readjson(String key) throws IOException, ParseException
	{
		FileReader inputfile=new FileReader("../VTIGER_prac/commonJSON.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(inputfile);
		HashMap jobj=(HashMap) obj;
		String value = jobj.get(key).toString();
		return value;
	}

}
