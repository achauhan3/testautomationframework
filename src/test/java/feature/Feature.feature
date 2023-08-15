Feature: This is a sample feature

  Scenario Outline: This is sample scenario outline
    Given I am on the home page
    When I click on the <link>
    Then I should see the <page>

    @test1
    Examples:
      | link  | page  |
      | link1 | page1 |

  @test2
  Scenario: This is sample scenario outline
    Given I am on the home page
    When I click on fetch the page values
    Then I validate the values

  @test_drag
  Scenario: This is sample scenario outline
    Given I am on the drag home page
    When I click on draggable item

  @test_alert
  Scenario: This is sample scenario outline
    Given I am on the alert home page
    When I click on simple alert box
    Then I dismiss the value

  @test_alert2
  Scenario: This is sample scenario outline
    Given I am on the alert home page
    When I click on promt alert box
    Then I enter the value
    Then I accept the value