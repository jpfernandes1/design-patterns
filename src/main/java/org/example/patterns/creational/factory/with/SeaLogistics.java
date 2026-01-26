package org.example.patterns.creational.factory.with;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}