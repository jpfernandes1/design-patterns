package org.example.principles.compositionOverInheritance.bad;

public class CombustionEngineTruck extends Truck {

    @Override
    public void move() {
        System.out.println("Moving a combustion engine truck.");
    }
}
