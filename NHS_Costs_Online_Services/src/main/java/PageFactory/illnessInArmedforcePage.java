package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class illnessInArmedforcePage extends BasePageObject {

	@FindBy(xpath="//input[@name='warPension']")
	List<WebElement> armedForce;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public illnessInArmedforcePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForIllnessInArmedforcePage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
		
	public void illnessRadioButtonjs(String testdataValue)
	{
		
		selectRadioButton(armedForce, testdataValue);
	}
	
	public void NavigateToAreYouDiabetic()throws Exception
	{
		ExplicitWait(driver,NextButton);
		NextButton.click();
	}
	
}
