package org.example.principles.compositionOverInheritance.bad;

public class AutopilotCombustionEngineTruck extends CombustionEngineTruck {

    @Override
    public void move() {
        super.move();
        System.out.println("Driving with autopilot.");
    }
}
