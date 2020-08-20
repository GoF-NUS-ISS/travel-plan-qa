@api
Feature: Travel plan api

  Scenario: User is able to Create new travel plan by sending 'Post' request to travel plan api
    Given API is up and running
    When User hit the api with post request with valid json body
    Then api returns "201" status code

  Scenario: User is able to Get the travel plan details by sending Get request to travel plan api
    Given API is up and running
    When User hit the api with get request with name query parameter value as "akash"
    Then api returns "200" status code
    And response body contains travel plan details for name "akash"