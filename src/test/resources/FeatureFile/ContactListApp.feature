@testthis
Feature: Test this feature

  Background:
    Given Launch Application

  Scenario: Registered User can Login and Logout Successfully
    Given User lands on the LoginPage
    When User enters email address
    And User enters password
    And User clicks on Submit
    Then User lands on Contact List Page
    And User clicks on Logout
    Then User lands on the LoginPage

  Scenario: Verify that an alert is displayed while using incorrect credentials
    Given User lands on the LoginPage
    When User enters incorrect email address
    And User enters incorrect password
    And User clicks on Submit
    Then alert message is displayed

  @runtest
  Scenario Outline: Error message should display after entering an invalid Email, Phone format
    Given User lands on the LoginPage
    When User enters email address
    And User enters password
    And User clicks on Submit
    When User clicks On Add Contact
    And User enter <firstName> and <lastName>
    And User enters incorrect <email> and <phone>
    And User clicks on Submit
    Then User verifies Contact validation is failed for email and phone
    And User clicks on Cancel

    Examples:
      | firstName | lastName | email       | phone  |
      | QT1       | Test1    | QT987654321 | ab1234 |
      | QT2       | Test2    | QT&^%54321  | mn9875 |
      | QT3       | Test3    | QT987L0*(21 | 1164   |
#      |            |          | QOOO7L0*(21 | LHG164 |
#      | QT5        |   Test5        | +++7L0*(21  | 123&*( |



#  Scenario: User can add a new contacts
#    Given User lands on the LoginPage
#    When User enters email address
#    And User enters password
#    And User clicks on Submit
#    Then User lands on Contact List Page
#    When User clicks On Add Contact
#    Then User lands on Add Contact Page
#    And User enter contact Details


#  Scenario: Registration Test case
#    Given User lands on the Homepage
#    When User enters email address
##    And User enters password