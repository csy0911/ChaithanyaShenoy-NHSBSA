package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavingPage extends BasePageObject {

	@FindBy(xpath="//input[@name='haveSavings']")
	List<WebElement> haveSavings;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public SavingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForSavingPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void haveSavingsRadioButton(String testdataValue)
	{
		selectRadioButton(haveSavings, testdataValue);
	}
	
	public void NavigateToResultsPage()
	{
		NextButton.click();
	}
	
	
}
