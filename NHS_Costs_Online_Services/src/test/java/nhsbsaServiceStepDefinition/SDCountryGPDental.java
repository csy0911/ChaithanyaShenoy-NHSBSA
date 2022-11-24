package nhsbsaServiceStepDefinition;


import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Scenario;

import PageFactory.CountryLiveInPage;
import PageFactory.HomePage;
import PageFactory.GPPracticePage;
import PageFactory.DentalPracticePage;
import Utility.BrowserFactory;


public class SDCountryGPDental extends AbstractStepDefinition {

	HomePage objHomePage;
	CountryLiveInPage objCountryLiveInPage;
	GPPracticePage objGPPracticePage;
	DentalPracticePage objDentalPracticePage;	
	
	
	
	
	@Given("^Read data for the scenario \"([^\"]*)\"$")
	public void Read_data_for_the_scenario(String DataSet) throws Exception
	{
		
		try {TestDataRead= Utility.ExcelDataReader.ExcelDataRead(config.ExcelSheetName(), DataSet);	
		System.out.println("Test name: "+ scenario.getName());
		//System.out.println("Test name: "+ scenario.getId());
		log.info("Finished reading of the file");
		}catch(Exception e) {
			log.info("Step Failed " +e.toString());
		}
		
	}
		
	
	
	@When("^UK citizen opens the nhsbsa service link$")
	public void UK_citizen_opens_the_nhsbsa_service_link() throws Exception
	{
		try{
		driver = BrowserFactory.StartApplication(driver, config.getBrowser(), config.getUrl());		
		}catch(Exception e) {
			log.info("Step Failed " +e.toString());
		}
	}
	
	
	
	
	@Then("^nhsbsa homepage to be displayed$")
	public void Open_Home_page()throws Exception
	{
				
		try{objHomePage = new HomePage(driver);
		
		objHomePage.AcceptTheCookies();
		objHomePage.verifyHeaderForHomePage();
		objHomePage.NavigateToCountryLiveInPage(); 
		
		log.info("Homepage displayed as expected");
		}catch(Exception e){
			log.info("Step Failed " +e.toString());
		}finally{
			takePageScreenshot("Country LiveIn Screen");
		}
	}
	
	@And("^user enter the country livein$")
	public void enters_Country_live_in()throws Exception
	{
		try{		
		objCountryLiveInPage = new CountryLiveInPage(driver);
		
		objCountryLiveInPage.verifyHeaderForCountryLiveInPage();
		objCountryLiveInPage.selectCountryLiveInRadioButtonjs(TestDataRead.get("CountryLiveIn"));
		objCountryLiveInPage.NavigateToGPPractice();
		log.info("Country LiveIn page displayed as expected");
		
		}catch(Exception e) {
			log.info("Step Failed " +e.toString());
			
		}finally {
			takePageScreenshot("GPPractice Screen");
			
		}
		
		
	}

	@And("^user enters the GP practice in$")
	public void enters_GP()throws Exception {
		try {
			
			objGPPracticePage = new GPPracticePage(driver);
			objGPPracticePage.verifyHeaderForGPPracticePage();
			objGPPracticePage.selectGPPracticeInRadioButton(TestDataRead.get("GPPracticeinScotlandorWales"));
			objGPPracticePage.NavigateToDentalPractice();
			log.info("GP Practice page displayed as expected");
			
		}catch(Exception e) {
			log.info("Step Failed " +e.toString());
			BrowserFactory.closeApplication(driver);
		}finally {
			takePageScreenshot("Dental page screen");
			
		}
	}
	
	@And("^user enters the Dental practice$")
	public void enters_Dental() throws Exception
	{
		try {
			
			objDentalPracticePage= new DentalPracticePage(driver);
			objDentalPracticePage.verifyHeaderForDentalPracticePage();
			objDentalPracticePage.selectDentalPracticeInRadioButton(TestDataRead.get("CountryDentalPractice"));
			objDentalPracticePage.NavigateToDOBPage();
			
			log.info("DOB page displayed as expected");
		}catch(Exception e) {
			log.info("Step Failed " +e.toString());
			BrowserFactory.closeApplication(driver);
		}finally {
			takePageScreenshot("DOB screen");
			
		}
		
	}
	
	
	
	
	
}
