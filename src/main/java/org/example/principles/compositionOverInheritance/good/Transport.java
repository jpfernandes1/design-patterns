package org.example.principles.compositionOverInheritance.good;


import org.example.principles.compositionOverInheritance.good.driver.Driver;
import org.example.principles.compositionOverInheritance.good.engine.Engine;

/**
 * Transport represents the core abstraction.
 *
 * IMPORTANT:
 * This class does NOT know concrete implementations of Engine or Driver.
 * It only depends on abstractions (interfaces).
 *
 * This follows:
 * - Composition over Inheritance
 * - Dependency Inversion Principle (DIP)
 * - Strategy Pattern
 */
public class Transport {

    private Engine engine;
    private Driver driver;

    public Transport(Engine engine, Driver driver) {
        this.engine = engine;
        this.driver = driver;
    }

    /**
     * High-level behavior that delegates work to composed objects.
     */
    public void deliver(String destination, String cargo) {
        System.out.println("Starting delivery of: " + cargo);
        engine.move();
        driver.navigate(destination);
        System.out.println("Delivery completed.\n");
    }

    /**
     * Behaviors can be replaced at runtime.
     * This is one of the main advantages of composition.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
