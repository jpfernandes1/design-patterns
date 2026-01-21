package org.example.principles.programToAnInterface.good;

public class Main {

    /*
     * WHY THIS DESIGN IS BETTER:
     *
     * 1. Company depends on abstractions (Employee), not concrete classes.
     * 2. New employee types can be added without changing Company.
     * 3. Business logic is reusable across different company types.
     * 4. Object creation is delegated to subclasses (Factory Method).
     * 5. The system is open for extension but closed for modification.
     *
     * Before:
     *  The Company class knew too much.
     *  It created objects, decided on types, and controlled everything.
     *
     * After:
     *  The Company class:
     *  only knows what it needs to know.
     *  depends on abstractions.
     *  delegates variable decisions to subclasses.
     *
     * BENEFITS:
     * - Lower coupling
     * - Better maintainability
     * - Easier testing
     * - Safer evolution of the system
     *
     * This is a practical example of:
     * - "Program to an interface, not an implementation"
     * - Factory Method design pattern
     */

    public static void main(String[] args) {
        Company company = new SoftwareCompany();
        company.runBusiness();
    }
}
