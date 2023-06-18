package com.hrm.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyDataUtility {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(iPathContent.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
	}
}
