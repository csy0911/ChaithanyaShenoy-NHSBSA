package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DentalPracticePage extends BasePageObject{

	@FindBy(xpath="//input[@name='dentalPracticeCountry']")
	List<WebElement> DentalPracticeIn;
	
	@FindBy(xpath="//input[@id='next-button']")
	WebElement NextButton;

	@FindBy(xpath="//h1[@id='question-heading']")
	WebElement header;
	
	public DentalPracticePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyHeaderForDentalPracticePage() throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void selectDentalPracticeInRadioButton(String testdataValue)
	{
		selectRadioButton(DentalPracticeIn, testdataValue);
	}
	
	public void NavigateToDOBPage()
	{
		NextButton.click();
	}
	
}
