package com.example.orderservicepatterns.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Order {
    private String id;
    private String description;
    private BigDecimal basePrice;
    private String paymentMethod;

    public Order(String description, BigDecimal basePrice, String paymentMethod) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.basePrice = basePrice;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public BigDecimal getBasePrice() { return basePrice; }
    public String getPaymentMethod() { return paymentMethod; }
}
