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
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
   Scenario: Register with mandatory details
    Given I am on the register page
    When I register with mandatory details
    Then I should see the account success message

  @tag2
  Scenario: Register with all details
    Given I am on the register page
    When I register with all details
    Then I should see the account success message

  @tag3
  Scenario: Register with existing email
    Given I am on the register page
    When I register with an existing email
    Then I should see a duplicate email warning message
    
  @tag4  
  Scenario: Register with wrong confirm password
    Given I am on the register page
    When I register with a wrong confirm password
    Then I should see a wrong confirm password warning message
  @tag5
  Scenario: Register with no details
    Given I am on the register page
    When I register with no details
    Then I should see all validation warnings