Feature: Create a customer using external dataSource
  Scenario: Create a customer using json file
    When i post request to create a customer using json file
    Then i should be able to create a customer
    And i should get 301 response