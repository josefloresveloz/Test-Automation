package com.bdd.stepdefinition;

import com.bdd.step.DemoBlazeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class DemoBlazeSD {

    @Steps
    private DemoBlazeStep demoBlazeStep;

    @Given("que ingreso a la web de compra")
    public void queIngresoALaWebDeCompra(){
        demoBlazeStep.queIngresoALaWebDeCompra();
    }

    @When("agrego dos producto al carrito")
    public void agregoDosProductoAlCarrito() {
        demoBlazeStep.agregoDosProductoAlCarrito();
    }

    @Then("realizo el pago")
    public void realizoElPago() {
        demoBlazeStep.realizoElPago();
    }
}
