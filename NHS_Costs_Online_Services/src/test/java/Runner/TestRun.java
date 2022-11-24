package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "FeatureFiles/CircumstanceCheckerTool.feature", 
glue = {"nhsbsaServiceStepDefinition" },
		plugin= {"pretty","json:target/cucumber.json"}		
		)	

public class TestRun {

}
