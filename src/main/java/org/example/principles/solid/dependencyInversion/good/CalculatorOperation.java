package org.example.principles.solid.dependencyInversion.good;

/**
 /**
 * ABSTRACTION INTERFACE (Contract)
 *
 * This interface defines the contract that all operations must follow.
 * It serves as an "abstraction layer" between:
 * - Calculator (high level) that uses operations
 * - AddOperation/SubOperation (low level) that implement operations
 *
 * APPLIED PRINCIPLE: "Abstractions should not depend on details.
 * Details should depend on abstractions."
 */

// It creates a stable abstraction that defines the contract that all operations must follow.
public interface CalculatorOperation {
    public int calculate(int a,int b);
}
