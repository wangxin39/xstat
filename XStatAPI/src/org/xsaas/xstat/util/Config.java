package org.xsaas.xstat.util;

import java.util.Properties;
import java.io.*;

public class Config {
	private static Properties prop=new Properties();
	static{
		try{
			Object object=new Config();
			InputStream in=object.getClass().getResourceAsStream("config.properties");
			prop.load(in);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getProperty(String name){
		return Config.prop.getProperty(name);
	}
	
}
