package nhsbsaServiceStepDefinition;


import PageFactory.CareHomePage;
import PageFactory.GlaucomaPage;
import PageFactory.MoreQuestionsPage;
import PageFactory.SavingPage;
import Utility.BrowserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SDmoreQuestionsGlaucomaCareHomeAnd16K extends AbstractStepDefinition{

	
	MoreQuestionsPage objMoreQuestionsPage;
	GlaucomaPage objGlaucomaPage;
	CareHomePage objCareHomePage;
	SavingPage objSavingPage;
	
	
	
	
	@Then("^user is asked for few more questions$")
	public void entersMoreQuestion()throws Throwable{
	try{
		
		objMoreQuestionsPage = new MoreQuestionsPage(driver);
		
		objMoreQuestionsPage.verifyHeaderForMoreQuestionsPage();
		objMoreQuestionsPage.MoreRadioButton(TestDataRead.get("MoreQuestonaries"));
		objMoreQuestionsPage.NavigateToGlaucomaPage();
		
		log.info("More question Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed " +e.toString());
		BrowserFactory.closeApplication(driver);
	}finally {
		takePageScreenshot("Glaucoma Page Screen");
	}
	
	}
	
	
	@And("^user enters if they have glaucoma$")
	public void enters_if_glaucoma()throws Throwable{
	try{
		
		objGlaucomaPage = new GlaucomaPage(driver);
		objGlaucomaPage.verifyHeaderForGlaucomaPage();
		objGlaucomaPage.GlaucomaRadioButton(TestDataRead.get("Glaucoma"));
		objGlaucomaPage.NavigateToCareHomePage();
				
		log.info("glaucoma Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed " +e.toString());
		BrowserFactory.closeApplication(driver);
	}finally {
		takePageScreenshot("CareHome Page Screen");
	}
	
	}
	
	@And("^user enters they stay in care home$")
	public void enters_CareHome()throws Throwable{
	try{
		
		objCareHomePage = new CareHomePage(driver);
		objCareHomePage.verifyHeaderForCareHomePage();
		objCareHomePage.inCareHomeRadioButton(TestDataRead.get("LiveInCareHome"));
		objCareHomePage.inCareHomeRadioButton(TestDataRead.get("More16KSaving"));
		objCareHomePage.NavigateToSavingPage();
				
		log.info("Care Home Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed " +e.toString());
		BrowserFactory.closeApplication(driver);
	}finally {
		takePageScreenshot("Saving Page Screen");
	}
	
	}
	
	
	
	
	@And("^user enters saving$")
	public void enters_Saving()throws Throwable{
	try{
		
		objSavingPage = new SavingPage(driver);
		objSavingPage.verifyHeaderForSavingPage();
		objSavingPage.haveSavingsRadioButton(TestDataRead.get("More16KSaving"));
		objSavingPage.NavigateToResultsPage();
				
		log.info("Saving Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed " +e.toString());
		BrowserFactory.closeApplication(driver);
	}finally {
		takePageScreenshot("Resultspage Screen");
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
