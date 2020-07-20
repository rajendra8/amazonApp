@BeforeLogin  @AfterLogin
Feature: Executing the login feature

  Background:
    Given I start the automation
    Then I executing the hookclass

  @createAccount
  Scenario: createaccount
    Given I click on "Signin on HomeScreen"
#    Then I wait until "createaccount" appears
    And I click on "createaccount"