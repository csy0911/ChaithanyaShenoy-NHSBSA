package nhsbsaServiceStepDefinition;

import PageFactory.DOBPage;
import PageFactory.LiveWithPartnerpage;
import PageFactory.TaxCreditorBenefitPage;
import Utility.BrowserFactory;
import io.cucumber.java.en.And;

public class SDdobPartnerAndTaxCredit extends AbstractStepDefinition {

	
	DOBPage objDOBPage;
	LiveWithPartnerpage objLiveWithPartnerpage;
	TaxCreditorBenefitPage objTaxCreditorBenefitPage;
	
	
	@And("^user enters the DOB$")
	public void enterDOB()throws Throwable{
	try{
		
		objDOBPage = new DOBPage(driver);
		
		objDOBPage.verifyHeaderForDOBPage();
		objDOBPage.EnterTheDOB(TestDataRead.get("DOB"));
		objDOBPage.NavigateToLiveWithpartnerPage();
		
		log.info("DOB Page is displayed as expected");
		System.out.println("Value from test data sheet  "+TestDataRead.get("DOB"));
	}catch(Exception e) {
		log.info("Step Failed -- DOB" +e.toString());
		BrowserFactory.closeApplication(driver);
	}finally {
		takePageScreenshot("Live with partner Screen");
	}
	
	}
	
	
	@And("^user enters whether live with partner or not$")
	public void Livewith_partner() throws Exception
	{
		try {
			
			objLiveWithPartnerpage = new LiveWithPartnerpage(driver);
			
			objLiveWithPartnerpage.verifyHeaderForCountryLiveInPage();
			objLiveWithPartnerpage.LiveWithPartnerRadioButton(TestDataRead.get("LiveWithPartner"));
			objLiveWithPartnerpage.NavigateToTaxCreditPage();
			
			log.info("Live with partner page is displayed as expected");
			
		}catch(Exception e) {
			log.info("Step Failed -- Live with partner" +e.toString());
			
		}finally {
			takePageScreenshot("Tax Credit Screen");
		}
		
	}
	
	
	@And("^user enters the benefits or tax credits$")
	public void Benefits_TaxCredit() throws Exception
	{
		try {
			
			objTaxCreditorBenefitPage = new TaxCreditorBenefitPage(driver);
			
			objTaxCreditorBenefitPage.verifyHeaderForTaxCreditorBenefitPage();
			objTaxCreditorBenefitPage.TaxCreditRadioButton(TestDataRead.get("ClaimTaxCredit"));
			objTaxCreditorBenefitPage.NavigateToAreYouPregnantPage();
			
			log.info("Tax Credit or Benefit page is displayed as expected");
			
		}catch(Exception e) {
			log.info("Step Failed-- Benefits_TaxCredit" +e.toString());
			
		}finally {
			takePageScreenshot("Pregnant Page Screen");
		}
		
	}
	
	
	
	

}

