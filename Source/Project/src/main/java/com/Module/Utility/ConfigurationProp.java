package com.Module.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProp {
	
	public String getConfigProp(String Name) throws IOException {
		FileInputStream  f = new FileInputStream("D:\\Divya-New\\Project\\workspace\\Project\\Configuration\\Config.properties");
		Properties p = new Properties();
		p.load(f);
		String S = p.getProperty(Name);
		return S;
	}

}
