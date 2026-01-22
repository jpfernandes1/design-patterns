package org.example.principles.compositionOverInheritance.good.engine;

/**
 * Concrete engine implementation.
 */
public class CombustionEngine implements Engine {

    @Override
    public void move() {
        System.out.println("Moving using a combustion engine.");
    }
}
