@TestDemoWeb
Feature: Test

  @Test
  Scenario: Agregar carrito
    Given que ingreso a la web de compra
    When agrego dos producto al carrito
    Then realizo el pago
