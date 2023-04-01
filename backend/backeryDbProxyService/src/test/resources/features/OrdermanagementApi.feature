Feature: other API should be able to use CRUD operations with the orders

  Scenario: a service wants retrieve all orders
    When a GET request will be made against the endpoint to grab all orders
    Then it should obtain 2 orders from the database

  Scenario: a service wants to fetch a specific order
    Given a valid order id "033b3d4c-bc58-4f16-b669-703fd12701d5"
    When a GET request will be made with an specific order id
    Then it should return an order with the id "033b3d4c-bc58-4f16-b669-703fd12701d5"

  Scenario: a service wants to create a order
    Given an order with the description "1234x Corn bread"
    When a POST request will be made in order to create a new order
    Then it should the new order with the description "1234x Corn bread"

  Scenario: a service wants to change information about a specific order
    Given a valid order id "033b3d4c-bc58-4f16-b669-703fd12701d5"
    When a PUT request will be made with an specific order id and providing a new description "order canceled"
    Then the existing order with the id "033b3d4c-bc58-4f16-b669-703fd12701d5" should appear with updated information
    Then the new order should have the new name "order canceled"

  Scenario: a service wants to delete an order from the database
    Given a valid order id "033b3d4c-bc58-4f16-b669-703fd12701d5"
    When a DELETE request will be made with an specific order id
    Then requesting order with id "033b3d4c-bc58-4f16-b669-703fd12701d5" should return an HTTP 404 error