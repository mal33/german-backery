Feature: other API should be able to use CRUD operations with the articles

  Scenario: a service wants retrieve all articles
    When a GET request will be made against the endpoint to grab all articles
    Then it should obtain 5 articles from the database

  Scenario: a service wants to fetch a specific article
    Given a valid article id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319"
    When a GET request will be made with an specific article id
    Then it should return 1 article with the id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319"

  Scenario: a service wants to create a article
    Given a bread name "Peter's bread" with the description "There is no description yet"
    When a POST request will be made in order to create a new article
    Then it should the new article with the name "Peter's bread" with the description "There is no description yet"

  Scenario: a service wants to change information about a specific article
    Given a valid article id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319"
    When a PUT request will be made with an specific article id and providing a new name "salty pepper bread"
    Then the existing article with the id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319" should appear with updated information
    Then the new article should have the new name "salty pepper bread"

  Scenario: a service wants to delete an article from the database
    Given a valid article id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319"
    When a DELETE request will be made with an specific article id
    Then requesting article with id "8f633d1d-08c8-41ad-9a9d-ba5cd0210319" should return an HTTP 404 error