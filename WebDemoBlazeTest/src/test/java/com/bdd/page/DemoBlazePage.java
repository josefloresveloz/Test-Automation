package com.bdd.page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoBlazePage extends PageObject {
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[2]/div/a")
    WebElementFacade agregarCarrito;
    @FindBy(xpath = "//*[@id=\"cartur\"]")
    WebElementFacade carrito;
    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/div/div[2]/button")
    WebElementFacade pagarOrden;
    @FindBy(id = "name")
    WebElementFacade nombre;
    @FindBy(id = "country")
    WebElementFacade pais;
    @FindBy(id = "city")
    WebElementFacade ciudad;
    @FindBy(id = "card")
    WebElementFacade numeroTarjeta;
    @FindBy(id = "month")
    WebElementFacade mes;
    @FindBy(id = "year")
    WebElementFacade año;
    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[2]/form")
    WebElementFacade formulario;

    public void agregoDosProductoAlCarrito() {

        int numItems = 2;
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.withTimeout(Duration.ofSeconds(20));
        for (int i = 1; i <= numItems; i++) {
            WebElementFacade seleccionaElemento = find(By.xpath("//*[@id='tbodyid']/div[" + i + "]/div/a/img"));
            seleccionaElemento.click();

            esperar();

            Serenity.takeScreenshot();
            wait.until(ExpectedConditions.visibilityOf(agregarCarrito));
            agregarCarrito.click();

            esperar();

            Serenity.takeScreenshot();
            // Manejar el alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept(); // Aceptar el alert

            // Esperar a que la página se cargue después de manejar el alert
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
            Serenity.takeScreenshot();

            esperar();

            if (i < numItems) {
                getDriver().navigate().to("https://www.demoblaze.com/index.html");

                esperar();

                // Espera a que la página se cargue completamente después del retroceso
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cat\"]")));
            }

        }
    }

    public void esperar() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void realizoElPago() {

        Serenity.takeScreenshot();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        carrito.waitUntilClickable().click();

        esperar();

        pagarOrden.waitUntilVisible().click();
        esperar();

        //rellenar formulario
        formulario.waitUntilVisible();
        nombre.sendKeys("Emmanuel");
        pais.sendKeys("Peru");
        ciudad.sendKeys("Trujillo");
        numeroTarjeta.sendKeys("123456789");
        mes.sendKeys("10");
        año.sendKeys("2028");

        esperar();

        Serenity.takeScreenshot();
        WebElementFacade btnPagar = find(By.xpath("//*[contains(text(),'Purchase')]"));

        btnPagar.waitUntilClickable().click();
        Serenity.takeScreenshot();

        esperar();

        Serenity.takeScreenshot();
        WebElementFacade btnOK = find(By.xpath("//*[contains(text(),'OK')]"));
        btnOK.waitUntilClickable().click();

        esperar();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cat\"]")));
        Serenity.takeScreenshot();

        getDriver().quit();
    }

}
