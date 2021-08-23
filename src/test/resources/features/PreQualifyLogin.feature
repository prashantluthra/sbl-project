@tag
Feature: Pre-qualify for a loan and create account

  @tag2
  Scenario Outline: Check if a user pre-qualifies for a loan and create an account
    Given I am on sba7a apply page
    When I select "Build my business or refinance an existing debt"
    And I select "SBA Loan" option
    And I add my peronal info as "<firstname>", "<lastname>", "<email>", "<phone>", "<businessname>", "<hearAbousUs>"
    And I accept terms and conditions
    And I click on Continue to PreQualify button
    And I will be directed to "/apply/loan" page
    And I click on Lets get started button
    And I will be directed to "/apply/prequalify/financing_needs" page
    And I select funding option "I’m flexible: about a month works for me"
    And I click on Save & continue button on financing needs page
    And I will be directed to "/apply/prequalify/business/inception_date" page
    And I select business started in "6-10 years ago"
    And I click on Save & Continue button on inception date page
    And I will be directed to "/apply/prequalify/business/industry" page
    And I select "Manufacturing" option from Business Industry drop down
    And I click on Save & Continue button on industry page
    And I will be directed to "/apply/prequalify/business/address" page
    And I enter address "378 East St, Bloomsburg, PA" auto suggestion will be displayed
    And I select auto suggested option by hovering over it
    And I click outside address textbox
    And I click on Save & Continue button on address page
    And I will be directed to "/apply/prequalify/business/employees" page
    And I select employees "6-10 employees"
    And I click on Save & Continue button on employees page
    And I will be directed to "/apply/prequalify/business/password" page
    And I enter password as "<password>"
    And I click on Save & Continue button on password page
    And I will be directed to "/apply/prequalify/owners" page
    And I check success message it should have users first name "<firstname>"
    And I click on logout button
    And I select "Yes, sign me out" on modal dialog
    And I will be directed to "/login" page
    And I enter "<email>" and "<password>"
    And I click on login button
    Then I will be able to login to the application

    Examples: 
      | firstname            | lastname            | email                                  | phone      | businessname  | hearAbousUs | password |
      | Test User First Name | Test User Last Name | test.automation822@smartbizloans.com   | 1234567234 | Test Business | Radio       | Test123! |
      | Test User First Name | Test User Last Name | test.automation823@smartbizloans.com   | 1234567234 | Test Business | Radio       | Test123! |
