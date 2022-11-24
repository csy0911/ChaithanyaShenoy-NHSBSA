package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaxCreditorBenefitPage extends BasePageObject {
	
	@FindBy(xpath="//input[@name='benefitsOrTaxCredits']")
	List<WebElement> taxCredit;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public TaxCreditorBenefitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForTaxCreditorBenefitPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void TaxCreditRadioButton(String testdataValue)
	{
		selectRadioButton(taxCredit, testdataValue);
	}
	
	public void NavigateToAreYouPregnantPage()
	{
		NextButton.click();
	}
	

}
