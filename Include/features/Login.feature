#Author: muhiyar.18@gmail.com

@Login
Feature: Login feature
  I want to use this template for my feature file

  @Login_Positif
  Scenario: Skenario Login Positif
    Given I Open Browser and navigate to Website
    When I input Username and Password and click login button
    Then I verify success login

  @Login_null_form
  Scenario: Skenario Login dengan form login kosong
    Given I Open Browser and navigate to Website
    When I click login button without input form
    And I verify get error required both field
    Then I verify still on the login page

  @Login_null_username
  Scenario: Skenario Login dengan form username kosong
    Given I Open Browser and navigate to Website
    When I click login button without input username
    And I verify get error required username field
    Then I verify still on the login page
    
  @Login_null_password
  Scenario: Skenario Login dengan form password kosong
    Given I Open Browser and navigate to Website
    When I click login button without input password
    And I verify get error required password field
    Then I verify still on the login page

  @Login_invalid_username
  Scenario: Skenario Login dengan form username invalid
    Given I Open Browser and navigate to Website
    When I click login button with invalid input username
    And I verify get error error Invalid Credential
    Then I verify still on the login page
    
  @Login_invalid_password
  Scenario: Skenario Login dengan form password invalid
    Given I Open Browser and navigate to Website
    When I click login button with invalid input password
    And I verify get error error Invalid Credential
    Then I verify still on the login page
    
  @Login_invalid_username_password
  Scenario: Skenario Login dengan form username dan password invalid
    Given I Open Browser and navigate to Website
    When I click login button with invalid input username dan password
    And I verify get error error Invalid Credential
    Then I verify still on the login page
    
    