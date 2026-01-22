package org.example.principles.compositionOverInheritance.bad;

/**
 * Adds the engine dimension (Electric) on top of Car.
 */
public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("Moving an electric car.");
    }
}
