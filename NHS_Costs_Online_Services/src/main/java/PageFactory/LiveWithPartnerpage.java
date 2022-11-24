package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveWithPartnerpage extends BasePageObject {

	@FindBy(xpath="//input[@name='partner']")
	List<WebElement> LiveWithPartner;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public LiveWithPartnerpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForCountryLiveInPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void LiveWithPartnerRadioButton(String testdataValue)
	{
		selectRadioButton(LiveWithPartner, testdataValue);
	}
	
	public void NavigateToTaxCreditPage()
	{
		NextButton.click();
	}
	
	
}
