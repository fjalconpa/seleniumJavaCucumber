@TradeMe
Feature: TradeMe UI and API tests

    Rule: This is a good place to put which business rule we are testing with this feature.

        Scenario: "As a user, I can see all the car makes on the Make dropdown"
            Given I navigate to the TradeMe Motor page
            Then I can verify that the number of car makes is 89

        Scenario Outline: "As a user, I can validate that each make has the right amount of cars listed"
            Given I navigate to the TradeMe Motor page
            When I select the car make <Make>
            Then I can verify that the number of car listed is <Number>
            Examples:
                | Make    | Number |
                | Ferrari | 44     |
                | BMW     | 2664   |
                | Mazda   | 4729   |
                | Honda   | 2312   |

        Scenario: "As a user, I want to verify the amount of car makes through the API"
            Given I send the request to the endpoint
            Then I can see there are 87 car makes