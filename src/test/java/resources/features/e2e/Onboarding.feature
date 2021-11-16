Feature: Verify Onboarding flow for iOS

  @e2e
  Scenario Outline: Verify Onboarding flow happy path iOS

    Given Appium server and simulator with application started
    And I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel                | signUpButton               |
      | Log In      | Welcome to ARBM Digibank | I'm new to [ARBM Digibank] |
    When I log in to product carousel page
    And I verify product carousel page is loaded
    Then I verify elements on product carousel page
      | logoLabel | openBankAccountButton | eligibilityLabel | instructionText                                                                    |
      | DigiBank  | Open Bank Account     | Am I eligible?   | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ullamcorper aliquet risus |
    And I verify elements on product carousel is spinning
    When I verify if I am eligible
    And I verify Eligibility criteria modal is loaded
    Then I verify elements on Eligibility criteria modal
      | I am a Malaysian with a MyKad, residing in Malaysia                       |
      | I am aged 18 and above                                                    |
      | I have an existing internet banking account with another bank in Malaysia |
      | I am NOT a US person                                                      |
      | I am NOT a tax resident in any other country                              |
      | I am applying for an individual account                                   |
    And I close eligibility modal
    Then I am openning bank account
    And I verify application flow page is loaded
    Then I verify elements on application flow page
      | logoLabel                       | labelFirst                            | labelSecond                                                            | signUpButton  |
      | This shouldn't take long at all | We pride ourselves on a quick sign up | Please ensure you have your MyKad with you before starting the process | Let's sign up |
    And I verify progress bar elements on application flow page
      | Sign up & ID verification |
      | Personal details          |
      | Create an account         |
      | Top up account            |
    When I'm processing to terms and conditions page
    Then I verify terms and conditions page is loaded
#    And I verify elements on terms and conditions page
    When I confirm all terms and conditions are met
    Then I verify eligibility page is loaded
#    And I verify elements on eligibility page
    When I select all eligibility criteria on eligibility page
    Then I confirm I am eligible and progress to name capture page
    And I verify name capture page is loaded

    When I enter <nameValue> value in name capture screen
    And I am processing to phone capture page
    And I verify phone capture page is loaded

    And I enter <invalidPhoneValue> phone value in phone capture screen
    Then I verify status of Confirm button is disabled

    And I enter <validPhoneValue> phone value in phone capture screen
    Then I verify status of Confirm button is enabled

    Examples:
      | nameValue | validPhoneValue | invalidPhoneValue |
      | Test name | 1122223333      | 11222233335       |