Feature: Search Functionality Check

   @ValidData
   Scenario: LMSTC001: Validate search with all valid fields
      Given Navigate to the search page
      When Enter valid data for all the fields
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | Flannery O'Connor | Edition 5   | fiction     | E_Books  | kids |
      And Click the Submit button
      Then Matching book record appears for the given criteria
      
   @MandatoryFields
   Scenario: LMSTC002: Validate mandatory fields
      Given Navigate to the search page
      When Leave some or all of the fields blank
  	  | Author            | Edition | Subject     | Format   | Age  |
  	  |                   |         |             |          |      |
      And Click the Submit button
      Then Blank fields show error message to fill the respective fields
      
   @InvalidAuthorName
   Scenario: LMSTC003: Validate Invalid Author Name
      Given Navigate to the search page
      When Enter Invalid Author Name and other fields correctly
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | @abc123           | Edition 5   | fiction     | E_Books  | kids |
      And Click the Submit button
      Then Error message or warning should be displayed for invalid author name
      
   @InvalidSubject
   Scenario: LMSTC004: Validate Invalid Subject
      Given Navigate to the search page
      When Enter Invalid subject and other fields correctly
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | Flannery O'Connor | Edition 5   | abc@123     | E_Books  | kids |
      And Click the Submit button
      Then Error message or warning should be displayed for invalid subject
      
   @CaseInSensitiveSearch
   Scenario: LMSTC005: Validating case insensitive search across all fields
      Given Navigate to the search page
      When Enter lowercase/mixed-case values for author name and subject
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | flannery o’connor | Edition 5   | Fiction     | E_Books  | Kids |
      And Click the Submit button
      Then Matching book is displayed
      
      
   @MismatchedAuthor
   Scenario: LMSTC006: Valid search with mismatched author
      Given Navigate to the search page
      When Enter valid but mismatched author
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | George Orwell     | Edition 5   | fiction     | E_Books  | kids |
      And Click the Submit button
      Then No Book Record is displayed
      
   @MismatchedSubject
   Scenario: LMSTC007: Validate search with mismatched subject
      Given Navigate to the search page
      When Enter valid but mismatched subject
  	  | Author            | Edition     | Subject     | Format   | Age  |
  	  | Flannery O'Connor | Edition 5   | non-fiction | E_Books  | kids |
      And Click the Submit button
      Then No Book Record is displayed