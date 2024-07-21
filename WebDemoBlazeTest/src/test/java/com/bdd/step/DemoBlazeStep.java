package com.bdd.step;

import com.bdd.page.DemoBlazePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class DemoBlazeStep extends ScenarioSteps {

    private DemoBlazePage demoBlazePage;

    @Step("que ingreso a la web de compra")
    public void queIngresoALaWebDeCompra() {

        // Configura WebDriverManager
        WebDriverManager.chromedriver().setup();

        demoBlazePage.open();
        getDriver().manage().window().maximize();

    }

    @Step("agrego dos producto al carrito")
    public void agregoDosProductoAlCarrito() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demoBlazePage.agregoDosProductoAlCarrito();
    }

    @Step
    public void realizoElPago() {
        demoBlazePage.realizoElPago();
    }
}
