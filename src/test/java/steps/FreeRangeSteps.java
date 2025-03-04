package steps;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

public class FreeRangeSteps {

    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaRegistro registroPage = new PaginaRegistro();

    @Given("^I navigate to www.freerangetesters.com?")
    public void iNavigateToFreeRangeTesters() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("^(?:I|The user|The client) selects Elegir Plan?")
    public void selectPlan() {
        landingPage.clickOnElegirPlan();
    }

    @When("^(?:I|The user|The client) selects? Introducción al Testing de Software?")
    public void navigateToIntro() {
        cursosPage.clickIntroduccionTestingLink();
    }
    
    @Then("^(?:I|The user|The client) can validate the options in the checkout page?")
    public void validateCheckoutPlans() {
        List<String> lista = registroPage.returnPlanDropDownvalues();
        List<String> listaEsperada = Arrays.asList("Academia: $26.99 / mes • 13 productos", "Academia: $176 / año • 13 productos", "Free: Gratis • 3 productos");

        Assert.assertEquals(lista, listaEsperada);
    }

    public void Ejemplulis() {
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        // Soft Assertions: No detienen la ejecución al fallar. Ideal para verificar
        // muchas cosas pequeñas a la vez.
        soft.assertEquals(palabraEsperada, palabraEncontrada);
        soft.assertTrue(palabraEncontrada.contains(palabraEsperada));
        soft.assertNotEquals(palabraEncontrada, palabraEsperada);

        soft.assertAll();

    }
}
