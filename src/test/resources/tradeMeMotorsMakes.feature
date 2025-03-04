@TradeMe
Feature: TradeMe UI and API tests

    Rule: This is a good place to put wich business rule we are testing with this feature.

        Scenario: "As a user, I can see all the car makes on the Make dropdown"
            Given I navigate to the TradeMe Motor page
            Then I can verify that the number of car makes is 89

        Scenario Outline: "As a user, I can validate that each make has the right amount of cars listed"
            Given I navigate to the TradeMe Motor page
            When I select "<Make>" from the Make dropdown
            Then I can verify that the amount of cars listed is "<Number>"
            Examples:
                | Make    | Number |
                | Ferrari | 46     |
                | BMW     | 2,654  |
                | Mazda   | 4,738  |
                | Honda   | 2,330  |
        Scenario: "As a user, I want to verify the amount of car makes throught the API"
            Given I send the request to the endpoint
            Then I can see there are 87 car makes