package PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject {

	WebDriver driver;
	
	public static Logger log = LogManager.getLogger();
	
	
	public void ExplicitWait(WebDriver driver, WebElement waitElement) throws Exception
	{
try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(waitElement));
	}catch(Exception e) {
		log.error("ExplicitWait failed -- " +e.toString());
	}
}
	
	public void selectRadioButton(List<WebElement> element, String TestDataValue)
	{
	 int ListSize = element.size();
		
	 for(int i=0; i<ListSize; i++)
	 {
		 String ListValue= element.get(i).getAttribute("value");
		 
		 if(ListValue.equalsIgnoreCase(TestDataValue))
		 {
			 element.get(i).click();
			 break;
		 }
	 }
	 
	}
	
	
	public void selectRadioButtonjs(List<WebElement> element, String TestDataValue)
	{
	 int ListSize = element.size();
		
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 	 
	 for(int i=0; i<ListSize; i++)
	 {
		 String ListValue= element.get(i).getAttribute("value");
		 
		 if(ListValue.equalsIgnoreCase(TestDataValue))
		 {
			 js.executeScript("arguments[0].click();", element.get(i));
			 break;
		 }
	 }
	 
	}
	
	
	
	
	
}
