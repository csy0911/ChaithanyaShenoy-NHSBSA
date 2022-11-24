package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserFactory {

	
	public static WebDriver StartApplication(WebDriver driver, String Browser, String url)
	{
	
		if (Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");			
			driver = new ChromeDriver();
		}
		else if (Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			
			FirefoxOptions options = new FirefoxOptions(); 
			options.addArguments("headless");
			driver = new FirefoxDriver(options);
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
			EdgeOptions options = new EdgeOptions();
			options.addArguments("headless");
			driver = new EdgeDriver(options);
		}
		
		else
		{
			System.out.println("Entered Browser name is incorrect");
		}
			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		//System.out.println("First instance Browser: "+ driver.getTitle());
	    return driver;  
		
	}
	
	
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}
	
}
