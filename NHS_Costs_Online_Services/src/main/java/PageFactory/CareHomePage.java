package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareHomePage extends BasePageObject {

	
	@FindBy(xpath="//input[@name='inCareHome']")
	List<WebElement> inCareHome;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public CareHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForCareHomePage() throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void inCareHomeRadioButton(String testdataValue)
	{
		selectRadioButton(inCareHome, testdataValue);
	}
	
	public void NavigateToSavingPage()
	{
		NextButton.click();
	}
	
	
}
