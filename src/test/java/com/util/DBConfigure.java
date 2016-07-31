package com.util;
public class DBConfigure {
	static String path ="";
	static{
		String basedir = DBConfigure.class.getClassLoader().getResource("").toString();		
	
		path = basedir.replace("file:/", "").replace("bin/", "") + "src/dbservers.xml";

	}
	
	public static void configure(String cf){
		
		path = cf; 
	}
}
