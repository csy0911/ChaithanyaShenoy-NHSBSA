#Author: chaihanyashenoy9@gmail.com
#Keywords Summary : To test the NHS circumstance cheker tool


@All_scenario
Feature: Circumstane check
 In order to get the NHS help options
 As a user
 I want to enter my circumstances
  
  
  @England
  Scenario Outline: Circumstance check for user living in England 
    Given Read data for the scenario "<DataSet>" 
    When UK citizen opens the nhsbsa service link
    Then nhsbsa homepage to be displayed
    And user enter the country livein
    And user enters the GP practice in
    And user enters the Dental practice
    And user enters the DOB
    And user enters whether live with partner or not
    And user enters the benefits or tax credits
    And user enters if they are pregnant
    And user enters the illness for Armed force
    And user enters if diabetic
    Then user is asked for few more questions
    And user enters if they have glaucoma
    And user enters they stay in care home
    And user enters saving
    Then user gets result of help from NHS
      
 

    Examples: 
      | DataSet  |
      | England |
      
   
 