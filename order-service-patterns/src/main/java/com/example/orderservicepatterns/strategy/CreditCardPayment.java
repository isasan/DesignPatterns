package com.example.orderservicepatterns.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay() {
        return "Pago realizado con tarjeta de crédito.";
    }
}
