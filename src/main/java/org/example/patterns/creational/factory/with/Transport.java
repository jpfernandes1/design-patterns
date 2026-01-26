package org.example.patterns.creational.factory.with;

public interface Transport {

    void deliver();
    double calculatePrice(double distance);
    void generateDocuments();

    // Richer interface → eliminates instanceof

}
