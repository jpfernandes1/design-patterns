package org.example.principles.compositionOverInheritance.bad;

/**
 * Adds the engine dimension (Combustion Engine) on top of Car.
 */
public class CombustionEngineCar extends Car {

    @Override
    public void move() {
        System.out.println("Moving a combustion engine car.");
    }
}
