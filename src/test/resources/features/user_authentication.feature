Feature: User Authentication
  As a user
  I want to authenticate with the application
  So that I can access the ExpertGuide features

  Scenario: Successful login with valid credentials
    Given a user exists with username "testuser" and password "password123"
    When the user logs in with username "testuser" and password "password123"
    Then the login should be successful
    And the user should be redirected to the dashboard

  Scenario: Failed login with invalid password
    Given a user exists with username "testuser" and password "password123"
    When the user logs in with username "testuser" and password "wrongpassword"
    Then the login should fail
    And an error message should be displayed "Invalid credentials"

  Scenario: Failed login with non-existent user
    When the user logs in with username "nonexistent" and password "password123"
    Then the login should fail
    And an error message should be displayed "User not found"

  Scenario: User logout
    Given a user is logged in
    When the user clicks logout
    Then the user should be redirected to the login page
    And the session should be terminated
