Feature: Search Functionality Check
   Scenario: Validating the Search Book with valid data
      Given Navigate to the search page
      When Enter valid data for all fields
      And Click the Search button
      Then Matching book record appears for the given criteria
      
   Scenario: Validate mandatory fields
      Given Navigate to the search page
      When Leave some or all of the fields blank
      And Click the Search button
      Then Blank fields show error message to fill the respective fields
      
   Scenario: Validating Search with mismatched author
      Given Navigate to the search page
      When Enter valid but mismatched author
      And Click the Search button
      Then Nothing is displayed 
      
   Scenario: Validating Search with mismatched subject
      Given Navigate to the search page
      When Enter valid but mismatched subject
      And Click the Search button
      Then No Book Record is displayed