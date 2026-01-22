package org.example.principles.compositionOverInheritance.bad;

public class ElectricTruck extends Truck {

    @Override
    public void move() {
        System.out.println("Moving an electric truck.");
    }
}
