Feature: API Testing - GET Request

	@Smoke
  Scenario: Retrieve resource from API
    Given User have a valid API
    When User send a GET request to Apple_iTune_API
    Then User gets the response status code should be 200

