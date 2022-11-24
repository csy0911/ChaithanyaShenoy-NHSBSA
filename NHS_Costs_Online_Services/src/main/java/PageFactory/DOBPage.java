package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DOBPage extends BasePageObject {

	
	@FindBy(xpath="//input[@id='dob-day']")
    WebElement day;
	
	@FindBy(xpath="//input[@id='dob-month']")
	WebElement month;
	
	@FindBy(xpath="//input[@id='dob-year']")
	WebElement year;
	
	
	@FindBy(xpath="//input[@id='next-button']")
	WebElement NextButton;

	@FindBy(xpath="//h1[@id='question-heading']")
	WebElement header;
	
	
	public DOBPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyHeaderForDOBPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void EnterTheDOB(String testdataValue)throws Exception
	{
		
		ExplicitWait(driver,year);
		
		String[] SplitArray= testdataValue.split("[/]");
		day.sendKeys(SplitArray[0]);
		month.sendKeys(SplitArray[1]);
		year.sendKeys(SplitArray[2]);
	}
	
	public void NavigateToLiveWithpartnerPage()
	{
		NextButton.click();
	}
	
	
	
	
	
	
	
	
	
}
