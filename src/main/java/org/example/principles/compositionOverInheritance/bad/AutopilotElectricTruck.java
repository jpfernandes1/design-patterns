package org.example.principles.compositionOverInheritance.bad;

public class AutopilotElectricTruck extends ElectricTruck {

    @Override
    public void move() {
        super.move();
        System.out.println("Driving with autopilot.");
    }
}
