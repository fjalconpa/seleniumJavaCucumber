package steps;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pages.TradeMeMotorPage;

public class TradeMeSteps {

    private ValidatableResponse json;
    private static RequestSpecification request;
    private Response response;

    TradeMeMotorPage tradeMe = new TradeMeMotorPage();

    @Given("I navigate to the TradeMe Motor page")
    public void navigateToTradeMeMotor() {
        tradeMe.navigateToTradeMeMotor();
    }

    @Then("I can verify that the number of car makes is {int}")
    public void returnAmountOfMakes(int makeAmount) {
        int expectedAmount = makeAmount;

        int actualAmount = tradeMe.makeDropdownSize();
        Assert.assertEquals(actualAmount, expectedAmount);
    }

    @When("I select {string} from the Make dropdown")
    public void selectCarMake(String make) {
        tradeMe.selectCarMake(make);
    }

    @Then("I can verify that the amount of cars listed is {string}")
    public void getNumberOfCarsMake(String carAmount) {
        tradeMe.clickSearchMake();
        Assert.assertEquals("Showing " + carAmount + " results", tradeMe.getResultsAmount());
    }

    @Given("I send the request to the endpoint")
    public void sendGETRequest() {
        RestAssured.useRelaxedHTTPSValidation(); // Trust all certificates
        request = given()
                .log().all().param("", "");
    }

    @Then("I can see there are {int} car makes")
    public void validateAmountOfMakes(int expectedMakeAmount) {
        response = request
                .when()
                .get("https://api.trademe.co.nz/v1/Categories.json");
        List<String> jsonResponse = response.jsonPath().getList("Subcategories[0].Subcategories[0].Subcategories.Name");
        Assert.assertEquals(expectedMakeAmount, jsonResponse.size(), "Mismatch on the expected total.");
    }
}
