Feature: This is a sample feature

  @test_api
  Scenario: This is sample scenario outline
    Given I setup the payload
    When I send a POST request to endpoint
    Then the response status should be 200