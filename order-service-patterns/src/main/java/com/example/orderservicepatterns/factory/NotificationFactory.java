package com.example.orderservicepatterns.factory;

public class NotificationFactory {
    public static Notification getNotifier(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Tipo desconocido");
        };
    }
}
