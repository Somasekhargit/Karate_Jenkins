Feature: Testing Petstore API

  Background:
    * url 'https://petstore.swagger.io/v2'

  Scenario: Retrieve pets by status
    Given path '/pet/findByStatus'
    And param status = 'available'
    When method get
    Then status 200
    And match response.[0].status == "available"