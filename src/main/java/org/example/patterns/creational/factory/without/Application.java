package org.example.patterns.creational.factory.without;

/*
    🔥 REAL PROBLEMS WITH THIS PACKAGE:

❌ 1. High coupling
    - LogisticsService knows ALL concrete classes
    - Each new transport → modifies this class

❌ 2. Use of instanceof and casting

    🚨 Classic red flag of bad design
    - Viola Liskov Substitution Principle
    - Abstraction (Transport) is insufficient

❌ 3. Class becomes a “God”

    Decide:

    - Which object to create
    - How to use it
    - How to handle exceptions
    - How to handle specific behaviors

❌ 4. Broken Open/Closed Principle

    Adding other types like: Train, plane...

    Requires:

    - New enum
    - New if/else statements
    - New instanceof statements
    - Risk of collateral bugs

❌ 5. Difficult testing

    Cannot be easily mocked
    Object creation is "hardcoded"

 */

public class Application {

    public void planDelivery(TransportType type, double distance) {

        Transport transport;

        // Centralized decision logic (God method)
        if (type == TransportType.TRUCK){
            transport = new Truck();
        } else if (type == TransportType.SHIP) {
            transport = new Ship();
        } else {
            throw new IllegalArgumentException("Unknown transport type");
        }

        transport.deliver();

        double price = transport.calculatePrice(distance);
        System.out.println("Delivery price: " + price);

        // Down casting reveals broken abstraction
        if (transport instanceof Truck) {
            ((Truck) transport).generateRoadDocuments();
        }
    }
}
