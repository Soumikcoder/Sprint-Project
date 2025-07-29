#feature file
Feature: Apply or Renew the Library card

    
@ValidDetails   
Scenario Outline: LMTC001: Validating the Library card with valid data
      Given Navigate to the url library card entry
      Then Enter the all the data and verify it "<row_index>"
     
        
     Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      
      
@EmptyDetails
Scenario: LMTC002: Verfying the details with empty field
   Given Navigate to the url library card entry
   When  The user left the field empty and enters the details aand click on submit
   Then  verify the details are not submitted
   
@InvalidEmail
Scenario Outline: LMTC004: Verifying Invalid Email
      Given Navigate to the url library card entry
      Then Enter the all the data and verify it "<row_index>" 
      
      Examples:
	      | row_index |
	      |         5 |
	      |         6 |
	      |         7 |
	  
@InvalidAge
Scenario Outline: LMTC005:Verifying Invalid Age Format
        Given Navigate to the url library card entry
        Then Enter the all the data and verify it "<row_index>" 
      
      Examples:
	      | row_index |
	      |         8 |
	      |         9 |
	      |         10|
	      |         11|
@InvalidPhoneNumber
Scenario Outline: LMTC005:Verifying Invalid Phone Number  Format
        Given Navigate to the url library card entry
        Then Enter the all the data and verify it "<row_index>" 
      
      Examples:
	      | row_index |
	      |         12|
	      |         13|
	      |         14|
	      |         15|	      

      