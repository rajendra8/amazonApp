@BeforeGetUrl

Feature: Doing BrowserTesting


  Background:
    Given I start the automation
    Then I executing the hookclass
    Then I wait for 20 seconds




  @cleartrip
  Scenario: cleartrip
    Given I open the "https://www.cleartrip.com/"
    Then I wait for "cleartripLogo " text
    Then I wait for "flightApp " text
    And I see "cleartripLogo" Test
    And I see "flightApp" Test
