Feature: Verify product carousel page functionality

  @carouselIOS
  Scenario: Verify elements on product carousel page
    Given Appium server and simulator with application type iOS started
    And I verify landing page is loaded
    When I log in to product carousel page
    And I verify product carousel page is loaded
    Then I verify elements on product carousel page
      | openBankAccountButton | eligibilityLabel | instructionText             |
      | Open Bank Account     | Am I eligible?   | Manage your money on the go |
    And I verify elements on product carousel is spinning

  @appflowIOS
  Scenario: Verify elements on application flow page
    Given Appium server and simulator with application type iOS started
    When I verify landing page is loaded
    And I log in to product carousel page
    And I verify product carousel page is loaded
    Then I am openning bank account
    And I verify application flow page is loaded
    Then I verify elements on application flow page
      | logoLabel                       | labelFirst                             | labelSecond                                                             | signUpButton  |
      | This shouldn't take long at all | We pride ourselves on a quick sign up. | Please ensure you have your MyKad with you before starting the process. | Let's sign up |
    And I verify progress bar elements on application flow page
      | Sign up & ID verification |
      | Personal details          |
      | Create an account         |
      | Top up account            |
