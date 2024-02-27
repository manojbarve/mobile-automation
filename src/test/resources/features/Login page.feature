@login
Feature: Login page verification feature
  This feature file covers the login page verification, scroll and product selection after successful login.

  #error scenario for log in verification
  @login
  Scenario Outline: Error flow for log in verification
    Given user launch the mobile application
    Then user enters "<username>" and "<password>"
    And validate whether the login is unsuccessful
    Examples:
      | username           | password |
      | alicer@example.com | 10203040 |

    #Happy flow for login verification, swipe down and select element
  @login
  Scenario Outline: Happy flow for log in verification and select product displayed in the bottom of the page.
    Given user launch the mobile application
    And user enters "<username>" and "<password>"
    When after successful login navigate to product page
    And navigate to the bottom of the page and select the product
    Then validate whether the product selection is successful

    Examples:
      | username        | password |
      | bob@example.com | 10203040 |