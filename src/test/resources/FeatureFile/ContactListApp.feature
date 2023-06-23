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

  @1234Abcd
  Scenario: Verify that an alert is displayed while using incorrect credentials
    Given User lands on the LoginPage
    When User enters incorrect email address
    And User enters incorrect password
    And User clicks on Submit
    Then alert message is displayed

  Scenario Outline: Verify that an error message is displayed when trying to register with an existing username
    Given User lands on the LoginPage
    When User clicks on SignUp
    Then User lands on Add User Page
    And User enter <firstName> and <lastName>
    When User enters email address
    And User enters password
    And User clicks on Submit
    Then "Email address is already in use" alert is displayed
    Examples:
      | firstName | lastName |
      | QT1       | Test1    |
      | QT2       | Test2    |

  Scenario: Verify that the user can delete a contact
    Given User lands on the LoginPage
    When User enters email address
    And User enters password
    And User clicks on Submit
    And User captures contacts
    When User clicks on contact
    Then User lands on Contact Details Page
    And User clicks on Delete
    Then User lands on Contact List Page
    Then User verifies the contact is deleted


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


  Scenario Outline: verify that a logged-in user can add a new contact with valid details.
    Given User lands on the LoginPage
    When User enters email address
    And User enters password
    And User clicks on Submit
    When User clicks On Add Contact
    And User enters <firstName> in the firstname field
    And User enters <lastName> in the lastname field
    And User enters <email> in the email field
    And User enters <phone> in the phone number field
    And User clicks on Submit

    Examples:
      | firstName | lastName | email          | phone      |
      | Preksha   | Vora     | Abcd@gmail.com | 6578964321 |
      | Raj       | Shah     | user@gmail.com | 1245698643 |
      | Rupa      | Patel    | rupa@gmail.com | 1245678965 |

  Scenario Outline: Verify that a logged-in user can edit the details of an existing contact.
    Given User lands on the LoginPage
    When User enters email address
    And User enters password
    And User clicks on Submit
    And User clicks on the existing contact need to be edited
    Then User lands on Contact Details Page
    And User clicks on the edit contact
    And User enters <city> in the city field
    And User enters <country> in the country field
    And User clicks on Submit

    Examples:
      | city   | country     |
      | Mumbai | Maharashtra |

#  Scenario: User can add a new contacts
#    Given L
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