package com.example.orderservicepatterns.facade;

import com.example.orderservicepatterns.builder.OrderBuilder;
import com.example.orderservicepatterns.decorator.BasePriceCalculator;
import com.example.orderservicepatterns.decorator.PromoDecorator;
import com.example.orderservicepatterns.factory.Notification;
import com.example.orderservicepatterns.factory.NotificationFactory;
import com.example.orderservicepatterns.model.Order;
import com.example.orderservicepatterns.strategy.CreditCardPayment;
import com.example.orderservicepatterns.strategy.PaymentStrategy;
import com.example.orderservicepatterns.strategy.PaypalPayment;

import java.math.BigDecimal;

public class OrderServiceFacade {

    public String processOrder(String desc, BigDecimal price, String paymentMethod, String notificationType) {
        // Crear pedido
        Order order = new OrderBuilder()
                .setDescription(desc)
                .setBasePrice(price)
                .setPaymentMethod(paymentMethod)
                .build();

        // Aplicar descuento
        PromoDecorator promo = new PromoDecorator(new BasePriceCalculator(order.getBasePrice()));
        BigDecimal finalPrice = promo.calculate();

        // Estrategia de pago
        PaymentStrategy strategy = switch (paymentMethod.toLowerCase()) {
            case "paypal" -> new PaypalPayment();
            case "creditcard" -> new CreditCardPayment();
            default -> throw new IllegalArgumentException("Método de pago no soportado");
        };

        // Notificación
        Notification notifier = NotificationFactory.getNotifier(notificationType);

        return String.format("""
                Pedido ID: %s
                Descripción: %s
                Precio final: %s
                Estado pago: %s
                Notificación: %s
                """,
                order.getId(),
                order.getDescription(),
                finalPrice,
                strategy.pay(),
                notifier.send("Tu pedido fue procesado"));
    }
}
