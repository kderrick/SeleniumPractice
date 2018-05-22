#Each feature file conains one feature
#Feature files user Gherkin language - business language
Feature: Test Login functionality on sdet university


#A feature may have given specific scenarios
#Scenarios use given/when/then structures
Scenario: The user should be able to login with correct user name and correct password
Given user is on the sign in page
When user enters correct username and correct password
Then user gets the confirmation