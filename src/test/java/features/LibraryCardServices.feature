@ServiceTests
Feature: Library Services Form Submission Testing
As a user I want to interact with Library Services options(Email, Call, Chat)
So that I can submit my queries successfully

@EmailTests(LMSETC001-003)
Scenario Outline: Submitting Email option with different inputs
  Given the user navigates to the Library Services form
  When the user selects "Email" option
  And enters email "<row_index>"
  And enters query "<row_index>"
  And clicks Submit
  Then verify the result is "<expected_result>" and the message should be "<expected_message>"
  
  Examples:
  | row_index | expected_result | expected_message       |
  | 1         | Success         | Mail Sent Successfully |
  | 2         | Success         | Invalid email          |
  | 3         | Error           | Please Enter Your Query|
 
  @CallTests(LMSETC004-005)
	Scenario: Verify call option displays correct information
  Given the user opens the call option
  Then verify the call message should be "Call our Librarian at 982-098-8900" and "Time : 10am - 3pm"
  
   @ChatTests(LMSETC006)
  Scenario: Verify chat submission with valid details
    Given the user opens the chat option
    When the user enters chat name "Rahul"
    And the user enters chat phone "9876543210"
    And the user enters chat query "Help with eBooks"
    And the user clicks on Submit for chat
    Then verify the chat result is "Success" and the message should be "Message Sent Successfully"

   @ChatTests(LMSETC007)
  Scenario: Verify chat submission with invalid phone number
    Given the user opens the chat option
    When the user enters chat name "Tina"
    And the user enters chat phone "1234"
    And the user enters chat query "Need journals"
    And the user clicks on Submit for chat
    Then verify the chat result is "Error" and the message should be "Phone must be 10 digits"
  