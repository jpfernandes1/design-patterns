package org.example.patterns.creational.factory.with;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by ship.");
    }

    @Override
    public double calculatePrice(double distance) {
        return distance * 1.2;
    }

    @Override
    public void generateDocuments() {
        // Ship-specific documents hidden behind abstraction
        System.out.println("Generating maritime transport documents.");
    }
}
