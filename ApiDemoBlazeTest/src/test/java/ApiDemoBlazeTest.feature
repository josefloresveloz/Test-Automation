@APIDemoBlaze
Feature: API DemoBlaze

  Scenario: crear un nuevo usuario en signup
    * def username = 'Emmanuel_Flores_Flores'
    * def password = '123456789'
    Given url 'https://api.demoblaze.com/signup'
    And request { "username": "#(username)", "password": "#(password)" }
    When method post
    Then status 200
    And match response == ""

  Scenario: crear un usuario existente en signup
    * def username = 'Emmanuel_Flores'
    * def password = '123456789'
    Given url 'https://api.demoblaze.com/signup'
    And request { "username": "#(username)", "password": "#(password)" }
    When method post
    Then status 200
    And match response.errorMessage == "This user already exist."

  Scenario: usuario y password correcto en login
    Given url 'https://api.demoblaze.com/login'
    And request {"username":"Emmanuel_Flores","password":"123456789"}
    When method post
    Then status 200

  Scenario: usuario y password incorrecto en login
    Given url 'https://api.demoblaze.com/login'
    And request {"username":"Emmanuel_Flores","password":"1234567890"}
    When method post
    Then status 200
    And match response.errorMessage == "Wrong password."