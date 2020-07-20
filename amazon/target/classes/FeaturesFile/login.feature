@BeforeLogin  @AfterLogin
Feature: Executing the login feature

  Background:
    Given I start the automation
    Then I executing the hookclass

  @createAccount
  Scenario: createAccount
    When I come to login page
    And I check login page
    Then I click on "new_user"
    Then I wait for 10 seconds
    And I wait until "Name" appears
    Then I enter "Raj" into "Name"
    Then I enter "9850550788" into "Mobile Number"
    Then I enter "ranu2290" into "Set Password"
    And I click on "Verify Mobile Number"
    And I click on "Sign in"
    And I click on "Create account . New to Amazon?"
    Then I enter "Raj" into "YourName"

  @Login
  Scenario:Login
    When I click on "Already a member,Sign In"
    And I wait for 10 seconds
    Then I enter "9850550788" into "email_login"
    And I click on "Continue"
    And I wait for 10 seconds
    Then I enter "ranu2290" into "password"
    Then I wait for 30 seconds
    Then I click on "Login"
    When I wait until "Category" appears

  @SearchItem
  Scenario: SearchItem
    Then I wait for 20 seconds
    When I wait until "Category" appears
    When I click on "Category"
    And I wait for 10 seconds
    When I wait until "TV, Appliances" appears
   Then I scroll till "TV, Appliances"
    And I wait for 5 seconds
    And I click on "TV, Appliances"
    When I wait until "Televisions" appears
    And I click on "Televisions"
    And I wait for 40 seconds
    Then I scroll till "View all"
    And I click on "View all 40 & 43 TVs"
    And I wait for 20 seconds
    And I scroll till "Sony Bravia 108 cm"
    And I wait for 20 seconds
    And I click on "Sony Bravia 801"
    And I scroll till "Add to Cart"
    And I wait for 20 seconds
    And I click on "Add to Cart"
#    Then I wait until "Proceed to checkout" appears
#    And I click on "Proceed to checkout"
#    And I wait until "Deliver to this address" appears
#    And I click on "Deliver to this address"


  @SearchTv
  Scenario: SearchTv
    When I wait until "Action Bar" appears
    Then I click on "Action Bar"
    Then I wait for 10 seconds
    And I click on "Action Bar Home"
    Then I wait for 10 seconds
    Then I enter "Sony Bravia 80" into "Search in All Categories"
    Then I wait for 10 seconds
    Then I click on Enter on Keyboard
    Then I wait for 10 seconds
    Then I wait for 10 seconds
    Then I scroll till "Sony Bravia 80"



