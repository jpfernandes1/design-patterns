package org.example.solid.dependencyInversion.bad;


/**
 * Parent module or main module of calculator which help to calculate
 * as per user's choice.
 * As per DIP rule it states:
 * High-level modules should not depend on low-level modules. Both should depend on abstractions.
 *  --- So above rule is broken our calculator class is directly dependent on low level class.
 *  Abstractions should not depend on details. Details should depend on abstractions
 *  --- Also is dependent on actual class.

 * VIOLATION OF THE DIP:

 * 1. Calculator (high level) directly depends on AddOperation and SubOperation (low level)
 * 2. There is no abstraction between them - Calculator knows the implementation details
 * 3. To add a new operation (e.g., MultiOperation):

 * - Modify Calculator (violates Open-Closed)
 * - Add a new case in the switch statement
 * - Instantiate a new concrete class
 *
 * Consequences:
 * - Difficult testability (cannot mock operations)
 * - Strong coupling (changes in AddOperation can break Calculator)
 * - Impossible reuse (Calculator cannot use other operations)
 *
 * Concepts Violated Visually:
 *
 *               Calculator (High Level)
 *               ↓ directly depends on ↓
 *  AddOperation (Low Level)   SubOperation (Low Level)
 *     concrete details ↑          ↑ concrete details
 *
 *
 * The correct thing would be:
 *
 *       Calculator (High Level)
 *           ↓ depends on ↓
 *   Operation (Abstraction/Interface)
 *           ↑ implemented by ↑
 *  AddOperation SubOperation MultiOperation
 *
 *
 *

 */
public class Calculator {
    public int calculate(int a, int b, String operation){
        int result = 0;
        switch(operation){
            case "add":
                // Clear violation: Calculator knows and depends on the concrete implementations
                AddOperation addOperation = new AddOperation(); // Direct creation
                result = addOperation.add(a,b);
            case "sub":
                // Clear violation: Calculator knows and depends on the concrete implementations
                SubOperation subOperation = new SubOperation(); // Direct creation
                result = subOperation.sub(a,b);
        }
        return result;
    }
}
