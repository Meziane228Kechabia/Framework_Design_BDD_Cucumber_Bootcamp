@TutorialsNinja

Feature: Login Functionnality of TutorialsNinja Application
@ValidCredentials
Scenario: Login with Valid Credentials
Given User navigates to login page
When User enters valid email "rewwah@gmail.com"
And User enters valid password "Meziane@123"
And User clicks on Login button
Then User is redirected to Account Page

@InvalidCredentials
Scenario: Login with Invalid Credentials
Given User navigates to login page
When User enters invalid email "rewwahhhhh@gmail.com"
And User enters invalid password "Meziane@12343"
And User clicks on Login button
Then User gets warning message about credentials mismatch 

@ValidEmailInvalidPassword
Scenario: Login with Valid email Invalid password
Given User navigates to login page
When User enters valid email "rewwah@gmail.com"
And User enters invalid password "Meziane@12343"
And User clicks on Login button
Then User gets warning message about credentials mismatch 

@InvalidEmailValidPassword
Scenario: Login with Invalid email Valid password
Given User navigates to login page
When User enters invalid email "rewwahhhhhh@gmail.com"
And User enters valid password "Meziane@123"
And User clicks on Login button
Then User gets warning message about credentials mismatch 


#@tag1
  #Scenario: Login with valid credentials
    #Given I am on the login page
    #When I login with valid credentials
    #Then I should see the account page with logout link
#
  #@tag2
  #Scenario: Login with invalid password
    #Given I am on the login page
    #When I login with invalid password
    #Then I should see a warning message
    #
  #@tag3
  #Scenario: Login with invalid email
    #Given I am on the login page
    #When I login with invalid email
    #Then I should see a warning message
    #
  #@tag4
  #Scenario: Login with no credentials
    #Given I am on the login page
    #When I login with no credentials
    #Then I should see a warning message
