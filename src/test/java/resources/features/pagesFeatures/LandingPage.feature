Feature: Verify landing page functionality

  @landIOS
  Scenario: Verify elements on landing page for iOS
    Given Appium server and simulator with application type iOS started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton    |
      | Log in      | Welcome to | I'm new to Ryse |

  @landAndroid
  Scenario: Verify elements on landing page for Android
    Given Appium server and simulator with application type Android started
    When I verify landing page is loaded
    Then I verify elements on landing page
      | logInButton | logoLabel  | signUpButton        |
      | Log In      | Welcome to | I'm new to Digibank |
    And I confirm tests completed with result TEST PASSED!!!

