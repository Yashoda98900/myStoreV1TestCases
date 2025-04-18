package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties properties;
	
 String path ="C:\\Users\\Public\\MyStoreV1\\Configuration\\config.properties";
 
 public ReadConfig() {
	 try {
		 properties = new Properties();
		 FileInputStream fix = new FileInputStream(path);
		 
	 } catch(Exception e) {
		 e.printStackTrace();
	 }	 
	 
 }
 
 public String getBaseUrl() {
	 String value = properties.getProperty("baseurl");
	 if(value !=null)
		 return value;
	 else
		 throw new RuntimeException("url not specificed in config file");
 }
 
 public String getBrowser() {
	 String value = properties.getProperty("browser");
	 if(value !=null)
		 return value;
	 else
		 throw new RuntimeException("url not specificed in config file");
 }
		 
}
