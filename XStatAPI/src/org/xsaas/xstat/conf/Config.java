package org.xsaas.xstat.conf;

import java.util.Properties;
import java.io.*;

public class Config {
	private static Properties prop = new Properties();
	static {
		try {
			Object object = new Config();
			InputStream in = object.getClass().getResourceAsStream("config.properties");
			prop.load(in);
		} catch (Exception e) {

		}
	}

	public static String getProperty(String name) {
		return Config.prop.getProperty(name);
	}
	
	public static int toInt(String name) {
		int ret = 0;
		try {
			ret = Integer.parseInt(Config.getProperty(name));
		} catch (Exception e) {
			
		}
		return ret;
	}

}
