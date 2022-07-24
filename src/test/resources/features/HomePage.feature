Feature: I am opening home page of our website and trying to do various login methods

  Scenario Outline: I want to verify the behaviour of test website with various login methods
    Given I am on home page of my test application with testsite url
    When I enter my "<valid_user>" username and "<valid_pwd>" password
    Then I am "<successful>" logged in to my account and get title as "<title>"
    And I can "<verify>" the applications on my home page

    Examples: 
      | valid_user               | valid_pwd    | successful       | verify     | title         |
      | apoorvlifeok@outlook.com | JUSTdance@96 | successfully     | verify     | Zoho Home     |
      #| valid                    | invalid      | not successfully | not verify | Zoho Accounts |
      #| invalid                  | valid        | not successfully | not verify | Zoho Accounts |
      #| invalid                  | invalid      | not successfully | not verify | Zoho Accounts |
