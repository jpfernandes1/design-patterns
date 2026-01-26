package org.example.patterns.creational.factory.with;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by truck.");
    }

    @Override
    public double calculatePrice(double distance) {
        return distance * 2.5;
    }

    @Override
    public void generateDocuments() {
        // Truck-specific documents hidden behind abstraction
        System.out.println("Generating road transport documents.");
    }
}
