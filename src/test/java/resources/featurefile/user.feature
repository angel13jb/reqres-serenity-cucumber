Feature:End To End Testing for user

  Scenario: User should be able to creat user successfully
    When I insert name and job
    And  I send post request to creat user
    Then I should be able to create new user succefully
    And  I should be able to get new user created Id

  Scenario: User should be able to get user with User id
    When I send a get request for fatching single user record by id
    Then I should be able to get single record
    And Verify name of the User created id

  Scenario: User should be able to update user by id
    When I insert name and job for updating  user
    And  I send patch request for updating user
    Then i should be able to update data in user

  Scenario: User should be able to delete user
    When I send request for deleting user
    And I should be able to delete user successfully
    And I should not able to get deleted record by deleted id