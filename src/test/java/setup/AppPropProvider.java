package setup;

import java.util.Properties;

import utils.PropertiesFactory;


public class AppPropProvider {
	static String fileName="application.properties";
	static Properties prop;
	public static void initialize() {
		
		//using the PropertiesFactory  class we get the properties object
		prop=PropertiesFactory.loadfile(fileName);
	}
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
