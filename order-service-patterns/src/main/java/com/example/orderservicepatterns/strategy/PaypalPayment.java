package com.example.orderservicepatterns.strategy;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public String pay() {
        return "Pago realizado con PayPal.";
    }
}
