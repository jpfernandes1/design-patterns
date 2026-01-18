package org.example.solid.dependencyInversion.good;

/**
 * One more submodule for subtraction
 *
 * These are implementation details that depend on abstraction.
 */
public class SubOperation implements CalculatorOperation {
    public int calculate(int a, int b) {
        return a - b;
    }
}
