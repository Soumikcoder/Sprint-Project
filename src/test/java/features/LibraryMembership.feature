@test
Feature: Check Membership feature
  I want to use this template for my feature file

  @EmptyNumber
  Scenario Outline: Validate Membership with blank Library card number
    Given Go to the Membership section 
    And drag and drop book
    When Select "<MembershipType>" Membership
    And Enter Blank Library card Number 
    And Click on Submit
    Then Error message "Please Enter Your Card number" should be displayed

    Examples: 
      |MembershipType|
      |Gold|
      |Platinum|

  @InvalidNumber
  Scenario Outline: Validate Membership with Invalid Library card number
    Given Go to the Membership section 
    And drag and drop book
    When Select "<MembershipType>" Membership
    And Enter "asddf" Library card Number 
    And Click on Submit
    Then The Message "Please Enter valid Library card Number" should be displayed

    Examples: 
      |MembershipType|
      |Gold|
      |Platinum|
   @ValidNumber
   Scenario Outline: Validate Membership with Valid Library card number
    Given Go to the Membership section 
    And drag and drop book
    When Select "<MembershipType>" Membership
    And Enter "95876543210" Library card Number 
    And Click on Submit
    Then The Message "Membership Added" should be displayed

    Examples: 
      |MembershipType|
      |Gold|
      |Platinum|