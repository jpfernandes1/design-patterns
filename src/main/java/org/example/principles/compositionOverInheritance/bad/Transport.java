package org.example.principles.compositionOverInheritance.bad;

/**
 * Base class for all transports.
 *
 * This class tries to be generic, but future subclasses will be forced to inherit behaviors they may not need.
 *
 * This class will be extended in several independent dimensions:
 * - vehicle type
 * - engine type
 * - navigation type
 * This leads to deep and rigid inheritance hierarchies.
 *
 * 🚨 Why this example is bad (and faithful to the book)
 *
 * ✘ Inheritance used for 3 different dimensions
 * ✘ Each new feature → more subclasses
 * ✘ Repeated code (autopilot, engine behavior)
 * ✘ Changes to the superclass break subclasses
 *
 *  It's not possible to:
 * change the engine at runtime
 * change navigation at runtime
 * evolve without breaking everything
 * It's not possible to change behavior at runtime
 *
 */

public abstract class Transport {

    public abstract void move();
}
