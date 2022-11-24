package PageFactory;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {
	
		
	@FindBy(xpath="//input[@id='next-button']")
	  WebElement startNow;
	
	@FindBy(xpath="//h1[text()='Check what help you could get to pay for NHS costs']")
     WebElement header;
	
	@FindBy(xpath="//*[@id='nhsuk-cookie-banner__link_accept_analytics']")
	 List<WebElement> ListcookiesOkButton;
	
	@FindBy(xpath="//*[@id='nhsuk-cookie-banner__link_accept_analytics']")
	 WebElement cookiesOkButton;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyHeaderForHomePage()throws Exception
	{
		ExplicitWait(driver,header);
	}

    public  void NavigateToCountryLiveInPage()
    {
    	startNow.click();
    }
    
    public void AcceptTheCookies()
    {
    	
    	if(ListcookiesOkButton.size()>=1)
    	{
    		cookiesOkButton.click();
    	}else {
    		System.out.println("No Cookies Asked for");
    	}
    	
    		
    }
    

}
