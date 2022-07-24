Feature: client can add accounts on on CRM home Page after loggin in to ZOHO

  Background: 
    Given I am on home page of my test application with testsite url
    When I enter my "apoorvlifeok@outlook.com" username and "JUSTdance@96" password
    Then I am "successfully" logged in to my account and get title as "Zoho Home"
    And I can "verify" the applications on my home page

  Scenario: client can add contact person and verify the person
    Given client is on home page of applications
    When client clicks on CRM on applications
    Then client clicks account from topmenu
    And client clicks on creates account
    And client enters Account information
    And client enters Address information
    And client enters display information
    Then client clicks on save button
