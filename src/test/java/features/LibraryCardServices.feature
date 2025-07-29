@EmailTests
Feature: Library Services Form Submission Testing
As a user I want to interact with Library Services options(Email, Call, Chat)
So that I can submit my queries successfully

Scenario Outline:  Submitting Email option with different inputs
  Given the user navigates to the Library Services form
  When the user selects "Email" option
  And enters email "<row_index>"
  And enters query "<row_index>"
  And clicks Submit
  Then verify the result is "<expected_result>" and the message should be "<expected_message>"
  
  

Examples:
  Examples:
  | row_index | expected_result | expected_message       |
  | 1         | Success         | Mail Sent Successfully |
  | 2         | Success         | Invalid email          |
  | 3         | Error           | Please Enter Your Query|