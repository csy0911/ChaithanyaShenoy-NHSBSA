# ChaithanyaShenoy-NHSBSA

>>Pull the file NHS_Costs_Online_Service from the repository
>>Open the command prompt and navigate to the folder called "NHS_Costs_Online_Service" where it is pulled locally. 
>>Type mvn clean andhit enter
>>Wait for maven to clean the project, once the Build is sucess
>>Type in mvn test -Dcucumber.options="--tags @England" and hit enter
>>Maven runs the runner file from the project for the tag name England
>>wait for Build to be sucess and then nvaigate to the below paath for the html report 
>> "NHS_Costs_Online_Services\target\Final-Report\cucumber-html-reports"

Note: Default setting is to run the BDD framework on Edge headless browser. 
Default browser can be changed to run on Chrome/ Firefox by changing the browser value in config.proeprties file, which can be found here "NHS_Costs_Online_Services\Config\config.proeprties"
