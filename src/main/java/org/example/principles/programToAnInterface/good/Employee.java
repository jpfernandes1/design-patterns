package org.example.principles.programToAnInterface.good;

/* Abstraction that defines what the company needs from an employee
    But why interface and not an abstract class?

    📌 When an Interface is the Best Choice

        Use an interface when:
        You want to define a contract
        You only need method signatures
        Implementations can be completely different
        You want maximum low coupling
        There can be multiple inheritances of behavior

    Rule of thumb: If you want to represent a "role" or "capability", and not a state, use an interface.

    Start by assuming the use of an interface. Evolve to an abstract class only when a real need arises.
    This need usually appears when you require at least one of the following:
        - Shared business logic
        - Common flow (template method)
        - Protected state
        - Controlled variation points
        - Code reuse across implementations
        - If none of this exists → an interface is sufficient and preferable.

 */
public interface Employee {

    void work();
}
