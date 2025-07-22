package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFactory {
	public static Properties loadfile(String fileName) {
		Properties properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream("src/test/resources/"+fileName);
			properties.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
