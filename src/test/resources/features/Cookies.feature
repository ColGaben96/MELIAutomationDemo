Feature: Configure Web Cookies and Check Website Behaviour

  @cookies @accept-button @custom-button @accept-personal @disable-personal @disable-personal-no-save
  Scenario Template: Check configuration Variables for Cookies
    Given I load the Cookies configuration variables <Row>
    |Sheet|
    |Setup|
    Examples:
    |Row|
    |1  |
    |2  |

  @cookies @accept-button
  Scenario Outline: Accept All Cookies From Button
    Given Cookies Banner appeared on browser <Row>
    |Sheet|
    |Cookies|
    When I click Understood
    Then Banner dissapear
    Examples:
    |Row|
    |2  |

  @cookies @custom-button @accept-personal
  Scenario Outline: Accept Cookies With Personal Cookies
    Given Cookies Banner appeared on browser <Row>
    |Sheet|
    |Cookies|
    When I click Customize Cookies
    And I click Save
    Then Banner dissapear
    Examples:
    |Row|
    |3  |

  @cookies @custom-button @disable-personal
  Scenario Outline: Accept Cookies Without Personal Cookies
    Given Cookies Banner appeared on browser <Row>
    |Sheet|
    |Cookies|
    When I click Customize Cookies
    And I disable Personal Cookies
    And I click Save
    Then Banner dissapear
    Examples:
    |Row|
    |1  |

  @cookies @custom-button @disable-personal-no-save
  Scenario Outline: Accept Cookies Without Personal Cookies And No Saving
    Given Cookies Banner appeared on browser <Row>
    |Sheet|
    |Cookies|
    When I click Customize Cookies
    And I disable Personal Cookies
    And I click Close
    Then Banner dissapear
    Examples:
    |Row|
    |3  |