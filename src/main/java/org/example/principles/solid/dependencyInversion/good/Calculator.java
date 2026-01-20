package org.example.principles.solid.dependencyInversion.good;



    /**
    * HIGH-LEVEL MODULE (Business Policy)
    *
    * Now depends only on the CalculatorOperation abstraction, not on concrete implementations.
    * This allows:
    * 1. TESTABILITY: Can receive mocks/stubs that implement CalculatorOperation
    * 2. EXTENSIBILITY: New operations do not require modification of this class
    * 3. FLEXIBILITY: Operations can be injected/configured externally
    *
    * APPLIED PRINCIPLE: "High-level modules should not depend on low-level modules.
    * Both should depend on abstractions."
    *
    * Example of use:
    * Calculator calc = new Calculator();
    * int result = calc.calculate(10, 5, new AddOperation());
    * int result2 = calc.calculate(10, 5, new SubOperation());
    */

/*
    Dependency inversion principle says that we should not have any dependency on any modules or submodules;
    As per DIP rule it states:

    --- So low level is dependent via CalculatorOperation rather being dependent on add or subtract operation
    Abstractions should not depend on details. Details should depend on abstractions
    -- Abstraction is achieved as via interface we are entering in low level.

    Improvements implemented:

    ✅ Abstraction Dependency: Receives CalculatorOperation as a parameter
    ✅ No Direct Creation: Does not instantiate concrete classes
    ✅ Closed for Modification: For a new operation, this class does not need to be modified
    ✅ Open for Extension: Accepts any new implementation of the interface

    BEFORE (Bad):                               NOW (Good):
    Calculator → AddOperation           Calculator → CalculatorOperation ← AddOperation
          ↓                                  ↑                  ↑
      SubOperation                        (Depends)         (Implements)

 */

public class Calculator {
    public int calculate(int a, int b, CalculatorOperation operation){
        return operation.calculate(a, b);
    }
}
