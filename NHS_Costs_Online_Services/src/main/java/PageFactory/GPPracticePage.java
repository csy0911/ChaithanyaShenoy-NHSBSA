package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GPPracticePage extends BasePageObject{
	
	
	@FindBy(xpath="//input[@name='gpPracticeInScotlandOrWales']")
	List<WebElement> GPPracticeIn;
	
	
	@FindBy(xpath="//input[@id='next-button']")
	WebElement NextButton;


	@FindBy(xpath="//h1[@id='question-heading']")
	WebElement header;
	
	
	public GPPracticePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForGPPracticePage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void selectGPPracticeInRadioButton(String testdataValue)
	{
		selectRadioButton(GPPracticeIn, testdataValue);
	}
	
	public void NavigateToDentalPractice()
	{
		NextButton.click();
	}
	
	
}
