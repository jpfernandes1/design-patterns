package org.example.patterns.creational.factory.without;

public class Ship implements Transport{

    @Override
    public void deliver() {
        System.out.println("Delivering by ship.");
    }


    @Override
    public double calculatePrice(double distance) {
        return distance * 1.2;
    }

    public void generateMaritimeDocuments() {
        // Specific behavior not shared with other transports
        System.out.println("Generating maritime transport documents.");
    }
}
