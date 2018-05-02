Feature: Access SouthWest.com and Find Flights

Scenario: Look For Flights
	Given User is on Home Page
	When User Look For Flights
	And User Enters Source as "MDW"
	And User Enters Destination as "LAX"
	Then Click On Adults
	And Add 2 Adults
	Then Click On Seniors
	And Add 3 Seniors
	Then User Click On Search Button
	Then User Displayed Successfully Search
	
Scenario: Read Searched Flight Detail
	When User read Searched Detail
	Then Display Searched Detail one bye one.

