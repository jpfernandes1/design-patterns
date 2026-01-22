package org.example.principles.compositionOverInheritance.bad;

/**
 * Adds the navigation dimension (Autopilot).
 *
 * FINAL RESULT:
 * A class that exists only because of a specific combination
 * of vehicle + engine + navigation.
 */
public class AutopilotElectricCar extends ElectricCar {

    @Override
    public void move() {
        super.move();
        System.out.println("Driving with autopilot.");
    }
}
