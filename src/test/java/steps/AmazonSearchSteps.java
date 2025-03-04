package steps;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {

    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon() {
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria) {
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToSencondPage(String pageNumber) {
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third option$")
    public void selectsThirdItem() {
        amazon.pickThirdItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void enterSearchCriteria() {
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
