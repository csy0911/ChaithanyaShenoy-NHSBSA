package PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends BasePageObject {

	@FindBy(xpath="//div[@class='result-option']")
	List<WebElement> results;
	

	@FindBy(xpath="//h1[@id='result-heading']")
    WebElement header;
	
	ArrayList<String> resultOutputList = new ArrayList<String>();
	
	public ResultsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyHeaderForResultsPage() throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	
	public ArrayList<String> captureResults()
	{
		int resultSize = results.size();
		
		for(WebElement i :results)
		{
			resultOutputList.add(i.getText());
			log.info("Results Output    :       "  +"/n" +i.getText());
		}
		
		return resultOutputList;
	}
	
	
	
}
