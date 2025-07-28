#feature file
Feature: Apply or Renew the Library card

    
@ValidDetails   
Scenario Outline: LMTC001: Validating the Library card with valid data
      Given Navigate to the url library card entry
      Then Enter the all the valid data and verify it "<row_index>"
     
        
     Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
      
@EmptyDetails
Scenario: LMTC002: Verfying the details with empty field
   Given Navigate to the url library card entry
   When  The user left the field empty and enters the details aand click on submit
   Then  verify the details are not submitted