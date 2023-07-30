Feature: Login to Leaftaps application

#Background: Login to application
#Given The url is loaded in the chrome
#When The username is entered as <demosalesmanager>
#And The password is entered as <crmsfa>
#And The Login button is clicked

#Scenario: Positive login to application
#Then Verify the home page is displayed


Scenario Outline: Positive login to application
Given The url is loaded in the chrome
When The username is entered as <username>
And The password is entered as <password>
And The Login button is clicked
Then Verify the home page is displayed

#Scenario: Negative login to application
#But Verify the error message is displayed
Examples:
|username|password|
|demosalesmanager|crmsfa|
|democsr|crmsfa|
