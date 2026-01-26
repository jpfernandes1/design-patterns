package org.example.patterns.creational.factory.with;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        // Subclass decides the concrete product
        return new Truck();
    }
}