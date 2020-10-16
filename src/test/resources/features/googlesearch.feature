Feature: Google Search

Scenario Outline: Google Text Search Test
	Given I go to google page
	When I search for "<key>"
	Then I should get results for "<key>"
	Examples:
	|key|
	|key1|
	|key2|