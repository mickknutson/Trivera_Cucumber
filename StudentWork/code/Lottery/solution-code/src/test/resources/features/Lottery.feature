#-----------------------------------------------------------------------------#
# What this feature is...
#-----------------------------------------------------------------------------#
Feature: Using the Lottery system to pick numbers

#-----------------------------------------------------------------------------#
Scenario: Enter Valid Data into Lottery System

	# Action: to Behavior
	Given 	User is on Home Page
	
	When 	User chooses '6' lottery numbers
	And     User wants a maximum range of '42' for lottery numbers

    When    User chooses to Pick My Lucky Numbers
	Then 	User is displayed Lottery results

#-----------------------------------------------------------------------------#

Scenario: Testing with invalid data

	Given 	User is on Lottery Page
	
	When 	User enters "ABC" for size and "ABC" for range
	And     User clicks to Pick My Lucky Numbers
    Then 	User is displayed an alert for size entry

	When 	User enters "5" for size and "ABC" for range
	And     User clicks to Pick My Lucky Numbers
    Then 	User is displayed an alert for range entry



#-----------------------------------------------------------------------------#
#Scenario Outline: Search two numbers <size> & <range>
#
#    Given User is on Lottery Page
#	When 	User enters "<size>" lottery numbers
#	And     User enters a maximum range of "<range>" for lottery numbers
#	When    User clicks to Pick My Lucky Numbers
#
#    Examples:
#      | size      | range     |
#      | 2         | 3         |
#      | 6         | 35        |
#-----------------------------------------------------------------------------#
