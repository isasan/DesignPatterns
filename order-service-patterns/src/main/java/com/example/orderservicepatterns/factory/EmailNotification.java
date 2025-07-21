package com.example.orderservicepatterns.factory;

public class EmailNotification implements Notification {
    @Override
    public String send(String message) {
        return "Email enviado: " + message;
    }
}
