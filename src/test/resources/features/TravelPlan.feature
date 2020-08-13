@ui
Feature: User is able to create Travel Plan

  Scenario: User is able to fill the form and save the first leg of the travel plan
    #Given User is logged in
    Given User is on "Create Travel Plan" Page
    #And User clicked on add first Travel leg link
    When User filled the form details as below
    And click on save button
    #Then User sees the success message and travel details are saved successfully