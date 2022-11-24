package nhsbsaServiceStepDefinition;


import PageFactory.Diabetic;
import PageFactory.PregnantPage;
import PageFactory.illnessInArmedforcePage;
import Utility.BrowserFactory;
import io.cucumber.java.en.And;

public class SDPregnantIllnessAndDiabetes extends AbstractStepDefinition {

	PregnantPage objPregnantPage;
	illnessInArmedforcePage objillnessInArmedforcePage;
	Diabetic objDiabeticPage;
	
	
	
	
	
	
	
	
	
	@And("^user enters if they are pregnant$")
	public void enterDiabetc()throws Throwable{
	try{
		
		objPregnantPage = new PregnantPage(driver);
		
		objPregnantPage.verifyHeaderForPregnantPage();
		objPregnantPage.AreYouPregnantRadioButton(TestDataRead.get("Pregnant"));
		objPregnantPage.NavigateToIllnessInArmedforce();
		
		log.info("Pregnant Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed-- PregnantPage" +e.toString());
		
	}finally {
		takePageScreenshot("PregnantPage Screen");
	}
	
	}
	
	
	
	
	
	@And("^user enters if diabetic$")
	public void enterifDiabetic()throws Throwable{
	try{
		
		objDiabeticPage = new Diabetic(driver);
		
		objDiabeticPage.verifyHeaderForDiabeticPage();
		objDiabeticPage.DiabeticRadioButton(TestDataRead.get("Diabetes"));
		objDiabeticPage.NavigateToMoreQuestions();
		
		log.info("Are you Diabetic Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed -- DiabeticPage" +e.toString());
		
	}finally {
		takePageScreenshot("DiabeticPage Screen");
		
	}
	
	}

	
	@And("^user enters the illness for Armed force$")
	public void enterIllness()throws Throwable{
	try{
		
		objillnessInArmedforcePage = new illnessInArmedforcePage(driver);
		
		objillnessInArmedforcePage.verifyHeaderForIllnessInArmedforcePage();
		objillnessInArmedforcePage.illnessRadioButtonjs(TestDataRead.get("IllnessInArmedForce"));
		objillnessInArmedforcePage.NavigateToAreYouDiabetic();
		
		
		log.info("Armed force illness Page is displayed as expected");
		
	}catch(Exception e) {
		log.info("Step Failed -- IllnessPage" +e.toString());
		
	}finally {
		takePageScreenshot("IllnessPage Screen");
	}
	
	}
	
	

	


}
