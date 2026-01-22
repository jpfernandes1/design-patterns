package org.example.principles.compositionOverInheritance.good.engine;

/**
 * Concrete engine implementation.
 */
public class ElectricEngine implements Engine {

    @Override
    public void move() {
        System.out.println("Moving using an electric engine.");
    }
}
