package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoreQuestionsPage extends BasePageObject{

	
	@FindBy(xpath="//input[@name='medicalConditionConfirmed']")
	List<WebElement> medicalConditionConfirmed;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public MoreQuestionsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForMoreQuestionsPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void MoreRadioButton(String testdataValue)
	{
		//ExplicitWait(driver,NextButton);		
		selectRadioButton(medicalConditionConfirmed, testdataValue);
	}
	
	public void NavigateToGlaucomaPage()
	{
		NextButton.click();
	}
	
	
}
