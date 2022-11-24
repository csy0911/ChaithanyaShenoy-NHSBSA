package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
			// Creating properties object so that it can be called through out the class
		static Properties pro;
		
		public ConfigReader()
		{
		 // Config path to be mentioned
			File src = new File("./Config/config.properties");
			
			try {
		// Read the config file and make it raw data		
				FileInputStream fis = new FileInputStream(src);
		// Object creation to be used later
				pro = new Properties();
				pro.load(fis);
				} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to read the Config File: " + e.getMessage());
			}
		}
			
		
		public static String getBrowser()
		{
			return pro.getProperty("Browser");
		}
		
		public static String getUrl()
		{
		 return pro.getProperty("URL");	
		}
		

		public static String ExcelSheetName()
		{
		 return pro.getProperty("ExcelSheetName");	
		}

}
