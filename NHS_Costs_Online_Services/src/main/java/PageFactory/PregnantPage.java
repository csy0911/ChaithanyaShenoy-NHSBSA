package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PregnantPage extends BasePageObject {
	@FindBy(xpath="//input[@name='pregnantOrGivingBirth']")
	List<WebElement> pregnant;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public PregnantPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForPregnantPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void AreYouPregnantRadioButton(String testdataValue)
	{
		selectRadioButton(pregnant, testdataValue);
	}
	
	public void NavigateToIllnessInArmedforce()
	{
		NextButton.click();
	}

}
