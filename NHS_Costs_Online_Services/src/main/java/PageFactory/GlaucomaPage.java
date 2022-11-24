package PageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlaucomaPage extends BasePageObject {
	
	@FindBy(xpath="//input[@name='glaucoma']")
	List<WebElement> glaucoma;
	
	
    @FindBy(xpath="//input[@id='next-button']")
    WebElement NextButton;
	
	
	@FindBy(xpath="//h1[@id='question-heading']")
    WebElement header;
	
	
	public GlaucomaPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHeaderForGlaucomaPage()throws Exception
	{
		ExplicitWait(driver,header);
	}
	
	public void GlaucomaRadioButton(String testdataValue)
	{
		selectRadioButton(glaucoma, testdataValue);
	}
	
	public void NavigateToCareHomePage()
	{
		NextButton.click();
	}
	

}
