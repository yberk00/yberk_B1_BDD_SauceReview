#@wip
Feature:  user should be able to login with valid credantials

  Background:
    Given The user is on the login page

  Scenario Outline: Login positive test
    When The user enters "<valid username>" and "<valid password>" credantials
    Then The user able to login SwagLabs website
    Examples:
      | valid username          | valid password |
      | standard_user           | secret_sauce   |
      | problem_user            | secret_sauce   |
      | performance_glitch_user | secret_sauce   |

  Scenario Outline: Login negative test
    When The user enters invalid or empty "<username>" or "<password>" credantials
    Then The user able to see "<error message>" login SwagLabs website
    Examples:
      | username        | password     | error message                                                             |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | sec_sauce    | Epic sadface: Username and password do not match any user in this service |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | problem_user    |              | Epic sadface: Password is required                                        |
      |                 |              | Epic sadface: Username is required                                        |
