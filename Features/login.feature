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
Feature: LOGIN	

@regression
  Scenario: Verify User is able to login with correct credentials
    Given user Launch Chrome Browser 
    When User opens url "https://app.mittarv.com/"
    And User enters Email as "tushar.sm435@gmail.com"
    And User clicks on "Send OTP" button
    Then User should be redirected to the OTP submission page
    
    When User is prompted to enter the OTP manually
    Then User enters the OTP
    And User clicks on the "Signup" button
    Then The user should be redirected to the dashboard with the title "Dashboard"
    
     When User clicks on the "Logout" link
    Then User should be logged out successfully
    And User closes the Browser