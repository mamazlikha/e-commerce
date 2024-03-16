Feature: Test to register new user

  Scenario: Add new user
    Given Empty database
    Given This user information
      | firstname | lastname | birthdate  | email        | phoneNumber | streetNumber | streetName            | zipCode | city           | country |
      | Anas      | Francis  | 07-10-1997 | anas@test.fr | 0707070707  | 36           | Avenue Paul Marcellin | 69120   | Vaulx-en-velin | France  |
    When the client calls 'POST' method with url 'users/register-user'
    Then the client receives status code of 201
