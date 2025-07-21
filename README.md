# 🧠 Order Service Patterns

Este es un microservicio de ejemplo desarrollado en **Java 17 + Spring Boot 3**, que demuestra el uso práctico de **patrones de diseño** en un backend REST. Fue generado paso a paso con la ayuda de **ChatGPT**, como parte de un plan intensivo de aprendizaje de IT.

> ✅ Ideal para desarrolladores backend que desean comprender y aplicar los patrones de diseño en escenarios reales.

---

## 🎯 Objetivo del proyecto

- Aprender patrones de diseño mediante ejemplos aplicados.
- Ver cómo interactúan entre sí en un servicio backend real.
- Practicar buenas prácticas de arquitectura en Java con Spring Boot.

---

## 🧱 Patrones de diseño aplicados

A continuación se detallan los patrones usados, junto con su propósito y cómo están implementados en el proyecto:

### 1. 🏗️ Builder Pattern
**Propósito:** Crear objetos complejos paso a paso, de forma legible y controlada.  
**Clase:** `OrderBuilder.java`  
**Uso:** Permite construir un objeto `Order` configurando propiedades opcionales de forma fluida.

```java
Order order = new OrderBuilder()
    .setDescription("Teclado mecánico")
    .setBasePrice(new BigDecimal("120"))
    .setPaymentMethod("creditcard")
    .build();
```

---

### 2. 🏭 Factory Pattern
**Propósito:** Crear objetos según un criterio sin exponer la lógica de instanciación.  
**Clases:** `NotificationFactory.java`, `EmailNotification`, `SmsNotification`  
**Uso:** Se utiliza para crear el canal de notificación adecuado según el tipo ("email" o "sms").

```java
Notification notifier = NotificationFactory.getNotifier("email");
notifier.send("Tu pedido fue procesado");
```

---

### 3. 🧠 Strategy Pattern
**Propósito:** Permitir cambiar dinámicamente el comportamiento de un algoritmo.  
**Interfaz:** `PaymentStrategy.java`  
**Implementaciones:** `PaypalPayment.java`, `CreditCardPayment.java`  
**Uso:** Selección dinámica del método de pago.

```java
PaymentStrategy strategy = new CreditCardPayment();
strategy.pay(); // "Pago realizado con tarjeta de crédito"
```

---

### 4. 🧩 Decorator Pattern
**Propósito:** Agregar responsabilidades adicionales a un objeto de forma dinámica.  
**Clases:** `BasePriceCalculator`, `PromoDecorator`  
**Uso:** Calcula un precio con descuento sin alterar la lógica base del cálculo.

```java
PriceCalculator calculator = new PromoDecorator(new BasePriceCalculator(price));
BigDecimal finalPrice = calculator.calculate();
```

---

### 5. 🧰 Facade Pattern
**Propósito:** Proveer una interfaz unificada a un conjunto de subsistemas.  
**Clase:** `OrderServiceFacade.java`  
**Uso:** Coordina todos los pasos (creación de orden, pago, descuento y notificación) en un único método.

```java
String result = facade.processOrder("Monitor", new BigDecimal("250"), "paypal", "sms");
```

---

## 🔧 Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Maven
- Arquitectura REST
- Programación Orientada a Objetos
- Principios SOLID

---

## ⚙️ Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/order-service-patterns.git
cd order-service-patterns
```

2. Importa el proyecto en tu IDE preferido (IntelliJ, VS Code, STS).

3. Asegúrate de tener Java 17 y Maven instalados.

4. Ejecuta la aplicación:

```bash
./mvnw spring-boot:run
```

5. Accede a la API en: `http://localhost:8080/orders/create`

---

## 📡 Uso de la API

### Endpoint

```
POST /orders/create
```

### Parámetros

| Parámetro    | Tipo    | Ejemplo     | Descripción                              |
|--------------|---------|-------------|------------------------------------------|
| description  | String  | Teclado     | Descripción del pedido                   |
| price        | Decimal | 100         | Precio base del producto                 |
| payment      | String  | creditcard  | Método de pago: `creditcard` o `paypal`  |
| notification | String  | email       | Notificación: `email` o `sms`            |

---

## 📲 Ejemplo con `curl`

```bash
curl -X POST "http://localhost:8080/orders/create?description=Monitor&price=250&payment=paypal&notification=sms"
```

### 🧾 Ejemplo de respuesta

```
Pedido ID: 12a3b456...
Descripción: Monitor
Precio final: 225.00
Estado pago: Pago realizado con PayPal.
Notificación: SMS enviado: Tu pedido fue procesado
```

---

## 🧠 Resumen visual en ASCII

```
┌────────────────────────┐
│  Patrones Creacionales │
└────────────────────────┘
  • Builder → crea objetos paso a paso
  • Factory → instancia objetos según tipo

┌────────────────────────┐
│ Patrones Estructurales │
└────────────────────────┘
  • Decorator → añade lógica sin modificar clase original
  • Facade → centraliza y simplifica llamadas a componentes

┌────────────────────────┐
│ Patrones de Comport.  │
└────────────────────────┘
  • Strategy → cambia comportamiento en tiempo de ejecución
```

---

## ✍️ Créditos

Este proyecto fue generado con **ChatGPT**, combinando inteligencia artificial y buenas prácticas de desarrollo para ofrecer una guía educativa completa sobre patrones de diseño.

---

## 📄 Licencia

MIT License — uso libre con fines educativos, personales o profesionales.
