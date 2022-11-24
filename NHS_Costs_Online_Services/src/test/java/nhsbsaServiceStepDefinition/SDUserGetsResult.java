package nhsbsaServiceStepDefinition;

import PageFactory.ResultsPage;
import Utility.BrowserFactory;
import Utility.ExcelDataReader;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;

public class SDUserGetsResult extends AbstractStepDefinition{

	ResultsPage objResultsPage;
	
	
	@Then("^user gets result of help from NHS$")
	public void reults() throws Exception{
	
		try {
			
			objResultsPage = new ResultsPage(driver);
			
			objResultsPage.verifyHeaderForResultsPage();
			resultOutputList= objResultsPage.captureResults();
			ExcelDataReader.auditTestExcel(resultOutputList);
			
			
			
		}catch(Exception e)
		{
			log.info("Step Failed-- Resultspage" +e.toString());
			BrowserFactory.closeApplication(driver);
		}finally {
			takePageScreenshot("Results Screen");
		}
		
	}
	
	@After()
	public void AfterScenario()
	{		
		//scenario.getStatus();
				
		BrowserFactory.closeApplication(driver);
	}
	
	
}
