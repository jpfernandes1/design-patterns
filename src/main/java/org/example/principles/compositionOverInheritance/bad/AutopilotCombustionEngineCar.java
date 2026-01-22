package org.example.principles.compositionOverInheritance.bad;

public class AutopilotCombustionEngineCar extends CombustionEngineCar {

    @Override
    public void move() {
        super.move();
        System.out.println("Driving with autopilot.");
    }
}
