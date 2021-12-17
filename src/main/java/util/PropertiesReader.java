package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	private static PropertiesReader propr = new PropertiesReader();
	private Properties props = new Properties();
	private InputStream input = null;
	
	private PropertiesReader() {
		try {
			input = getClass().getClassLoader().getResourceAsStream("connection.properties");
			props.load(input);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static PropertiesReader getInstance() {
		return propr;
	}
	
	public String getValue(String key) {
		return props.getProperty(key);
	}
}
