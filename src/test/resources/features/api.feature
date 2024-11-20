Feature: Testing CRUD operations on Reqres API

  Scenario: Create a user
    Given I set the API endpoint for creating a user
    When I send a POST request with valid user details
    Then I should receive a 201 status code
    And the response should contain the user details

  Scenario: Get a user by ID
    Given I set the API endpoint for retrieving a user
    When I send a GET request with user ID "2"
    Then I should receive a 200 status code
    And the response should contain the user ID "2"

  Scenario: Update a user
    Given I set the API endpoint for updating a user
    When I send a PUT request to update the user role
    Then I should receive a 200 status code
    And the response should reflect the updated role

  Scenario: Delete a user
    Given I set the API endpoint for deleting a user
    When I send a DELETE request with user ID "2"
    Then I should receive a 204 status code