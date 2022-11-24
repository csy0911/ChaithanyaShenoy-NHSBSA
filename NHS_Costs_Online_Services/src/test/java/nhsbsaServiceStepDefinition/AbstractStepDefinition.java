package nhsbsaServiceStepDefinition;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Utility.BrowserFactory;
import Utility.ConfigReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import nhsbsaServiceStepDefinition.SDCountryGPDental;

public abstract class AbstractStepDefinition {

	// To get the browser and URL from config.properties files kept in config folder
	ConfigReader config = new ConfigReader();
	
	public static WebDriver driver;
	public static Scenario scenario;
	public static HashMap<String,String>TestDataRead;
	public static ArrayList<String> resultOutputList;
	public static Logger log = LogManager.getLogger();
	
	
		
	
	public void takePageScreenshot(String name) throws Exception
	{
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./target/" + name+".png");
		FileUtils.copyFile(src, dest);
	}
	
}
