package com.example.orderservicepatterns.decorator;

import java.math.BigDecimal;

public class PromoDecorator implements PriceCalculator {
    private final PriceCalculator calculator;

    public PromoDecorator(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public BigDecimal calculate() {
        return calculator.calculate().multiply(new BigDecimal("0.90")); // 10% off
    }
}
