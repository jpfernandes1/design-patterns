package org.example.patterns.creational.factory.without;

public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivering by truck");
    }

    @Override
    public double calculatePrice(double distance) {
        return distance * 2.5;
    }

    public void generateRoadDocuments() {
        // Specific behavior not shared with other transports
        System.out.println("Generating road transport documents.");
    }
}
