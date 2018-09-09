#-----------------------------------------------------------------------------#
# What this feature is...
#-----------------------------------------------------------------------------#
@slowTests
Feature: Demo Features

#-----------------------------------------------------------------------------#
@favorite @jira123
  Scenario: Testing inline Point table

    Given I have coordinates:
    # column names first line
      | x   | y   |
      | 2.2 | 3.3 |
      | 4.4 | 5.5 |
      | 6.6 | 7.7 |
    When insert these coordinates


#-----------------------------------------------------------------------------#
@ignore
  Scenario: Testing inline JSON table

    Given I have JSON:
      | {"firstName": "Mick","lastName": "Knutson","email":"mknutson@baselogic.io"}|
      | {"firstName": "Chuck","lastName": "Norris","email":"chuck@norris.punch"}|

#-----------------------------------------------------------------------------#
# DataTable<Map<String, List<String>>>
#-----------------------------------------------------------------------------#
