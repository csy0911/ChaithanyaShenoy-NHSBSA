package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class CountryLiveInPage extends BasePageObject {

	
	@FindBy(xpath="//input[@name='livingCountry']")
	List<WebElement> CountryLiveIn;
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public CountryLiveInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForCountryLiveInPage() throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void selectCountryLiveInRadioButtonjs(String testdataValue)
	{
		selectRadioButton(CountryLiveIn, testdataValue);
	}
	
	
	
	
	public void NavigateToGPPractice()
	{
		NextButton.click();
	}
	
	
}
