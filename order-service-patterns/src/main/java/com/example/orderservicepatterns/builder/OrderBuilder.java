package com.example.orderservicepatterns.builder;

import com.example.orderservicepatterns.model.Order;

import java.math.BigDecimal;

public class OrderBuilder {
    private String description;
    private BigDecimal basePrice;
    private String paymentMethod;

    public OrderBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public OrderBuilder setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Order build() {
        return new Order(description, basePrice, paymentMethod);
    }
}
