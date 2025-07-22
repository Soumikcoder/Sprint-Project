#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@tag
Feature: Library Services Form Submission Testing
As a user I want to interact with Library Services options(Email, Call, Chat)
So that I can submit my quries successfully

@EmailValid
Scenario: LMSETC001 - Email option with valid submission
  When the user selects the Email Option
  And enters valid email "user@example.com"
  And enters query "Need book on AI"
  And clicks Submit
  Then a success message should be displayed
  And the service log should contain "medium=Email" and "From: user@example.com" and "Query: Need book on AI"
  
@EmailInvaild
Scenario: LMSETC002 - Email option with invalid email format
	When the user selects the Email option
	And enters invalid email "user@@.com"
	And enters query "Requesting materials"
  And clicks Submit
  Then error message "Invalid email format" should be displayed
  And no service request should be sent
  
@EmailNoQuery
 Scenario: LMSETC003 - Email option with missing query
   When the user selects the Email option
   And enters valid email "test@mail.com"
   And leaves the query field empty
   And clicks Submit
   Then error message "Query is required" should be displayed
 