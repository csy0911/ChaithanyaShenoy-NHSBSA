package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Diabetic extends BasePageObject {

	@FindBy(xpath="//input[@name='diabetes']")
	List<WebElement> diabetes;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public Diabetic(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForDiabeticPage() throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void DiabeticRadioButton(String testdataValue)
	{
		selectRadioButton(diabetes, testdataValue);
	}
	
	public void NavigateToMoreQuestions()
	{
		NextButton.click();
	}
	
	
}
