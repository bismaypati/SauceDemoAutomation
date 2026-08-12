package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties = new Properties();

	static {
		try {
			String path = "src/main/resources/config.properties";
			System.out.println("Config path: " + new java.io.File(path).getAbsolutePath());

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
