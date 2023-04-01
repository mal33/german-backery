Feature: other API should be able to use CRUD operations with the users

  Scenario: a service wants retrieve all users
    When a GET request will be made against the endpoint to grab all users
    Then it should obtain 2 users from the database

  Scenario: a service wants to fetch a specific user
    Given a valid user id "b9138e34-8755-4dca-91ad-59396a64ee8d"
    When a GET request will be made with an specific user id
    Then it should return an user with the id "b9138e34-8755-4dca-91ad-59396a64ee8d"

  Scenario: a service wants to create a user
    Given a username "darkbreadiscool" with the password "jelly123"
    When a POST request will be made in user to create a new user
    Then it should the new user with the username "darkbreadiscool"
    Then the hashed password should be equivalent to "jelly123"

  Scenario: a service wants to change information about a specific user
    Given a valid user id "b9138e34-8755-4dca-91ad-59396a64ee8d"
    When a PUT request will be made with an specific user id and providing a new username "MrRyebread"
    Then the existing user with the id "b9138e34-8755-4dca-91ad-59396a64ee8d" should appear with updated information
    Then the new user should have the new name "MrRyebread"

  Scenario: a service wants to delete an user from the database
    Given a valid user id "b9138e34-8755-4dca-91ad-59396a64ee8d"
    When a DELETE request will be made with an specific user id
    Then requesting user with id "b9138e34-8755-4dca-91ad-59396a64ee8d" should return an HTTP 404 error