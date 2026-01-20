package org.example.principles.solid.dependencyInversion.good;

/**
 * LOW-LEVEL MODULE (Implementation Detail)
 *
 * This is a concrete implementation of the CalculatorOperation abstraction.
 * Important notes:
 * - Depends on the abstraction (implements the interface)
 * - Can be replaced by any other implementation without affecting Calculator
 * - Represents a "detail" that can change without impacting the system
 *
 * Example of inversion: The dependency now goes from bottom to top
 * (AddOperation → CalculatorOperation ← Calculator)
 */

public class AddOperation implements CalculatorOperation {
    public int calculate(int a, int b) {
        return a + b;
    }
}
