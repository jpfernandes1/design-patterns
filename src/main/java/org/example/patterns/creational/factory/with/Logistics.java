package org.example.patterns.creational.factory.with;

public abstract class Logistics {

    public void planDelivery(double distance){

        // Factory method encapsulates object creation
        Transport transport = createTransport();

        transport.deliver();

        double price = transport.calculatePrice(distance);
        System.out.println("Delivery price: " + price);

        transport.generateDocuments();
    }

    // Factory Method
    protected abstract Transport createTransport();

}
