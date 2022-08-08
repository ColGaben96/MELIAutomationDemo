Feature: Want to search products

  @product-search @search-bar @search-menu
  Scenario Template: Check configuration Variables for Product Search
    Given I load the Product Search configuration variables <Row>
    |Sheet|
    |Setup|
    Examples:
    |Row|
    |1  |
    |2  |

  @product-search @search-bar
  Scenario Outline: Search something from product bar
    Given I accept navigation cookies and search for a product <Row>
    |Sheet|
    |ProductSearch|
    Then A list of products should appear
    Examples:
    |Row|
    |1  |
  @product-search @search-menu
  Scenario Outline: Search something from categories menu
    Given I accept navigation cookies and click for a category <Row>
    |Sheet|
    |ProductSearch|
    When I search for a product
    And check if I should filter just in that category and click search
    Then A list of products should appear
    Examples:
    |Row|
    |2  |
    |3  |