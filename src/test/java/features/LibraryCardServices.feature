@EmailTests
Feature: Library Services Form Submission Testing
As a user I want to interact with Library Services options(Email, Call, Chat)
So that I can submit my queries successfully

Scenario Outline: LMSETC001 - Submitting Email option with different inputs
  Given the user navigates to the Library Services form
  When the user selects "Email" option
  And enters email "<row_index>"
  And enters query "<row_index>"
  And clicks Submit
  Then verify the result is "Success"
  And the message should be "<expected_message>"

Examples:
  | row_index | expected_message                |
  | 1         | Submitted Successfully          |
  | 2         | Invalid email format            |
  | 3         | Query field cannot be empty     |
