package com.example.orderservicepatterns.controller;

import com.example.orderservicepatterns.facade.OrderServiceFacade;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceFacade facade = new OrderServiceFacade();

    @PostMapping("/create")
    public String createOrder(
            @RequestParam String description,
            @RequestParam BigDecimal price,
            @RequestParam String payment,
            @RequestParam String notification
    ) {
        return facade.processOrder(description, price, payment, notification);
    }
}
