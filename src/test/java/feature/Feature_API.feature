Feature: This is a sample feature

  @test_api
  Scenario: This is sample scenario outline
    Given I setup the payload
    When I send a GET request to endpoint
    Then the response status should be 200


  @test_api_post
  Scenario Outline: This is sample scenario outline
    Given I setup the payload
    When I send a POST request with "<name>" "<job>" to endpoint
    Then the response status should be 201

    Examples:
      | name  | job   |
      | test  | test  |
      | test1 | test1 |
      | test2 | test2 |