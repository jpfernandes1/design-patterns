package org.example.solid.liskovSubstitution.bad;

/**
 * Demonstration class showing Liskov Substitution Principle violation
 * This example clearly shows how the system breaks when trying to
 * use CreditCardLoan as a substitute for LoanPayment interface
 */
public class LSPViolationDemo {

    public static void main(String[] args) {
        System.out.println("=== LISKOV SUBSTITUTION PRINCIPLE VIOLATION DEMONSTRATION ===\n");

        // Scenario 1: System working correctly with HomeLoan
        System.out.println("SCENARIO 1: HomeLoan (works correctly)");
        LoanPayment homeLoan = new HomeLoan();
        executeLoanOperations(homeLoan);

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Scenario 2: System BREAKING with CreditCardLoan
        System.out.println("SCENARIO 2: CreditCardLoan (BREAKS the system!)");
        LoanPayment creditCardLoan = new CreditCardLoan();
        executeLoanOperations(creditCardLoan);

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Demonstrate LoanClosureService failure
        System.out.println("SCENARIO 3: LoanClosureService with different loan types");
        demonstrateLoanClosureService();

        System.out.println("\n" + "=".repeat(60) + "\n");

    }

    /**
     * Executes standard loan operations on any LoanPayment
     * This method expects ALL LoanPayment implementations to work
     * Demonstrates LSP violation when CreditCardLoan fails
     */
    private static void executeLoanOperations(LoanPayment loan) {
        System.out.println("Loan type: " + loan.getClass().getSimpleName());

        // Operation 1: Payment - should work for all implementations
        System.out.print("1. Processing payment... ");
        loan.doPayment(1000);
        System.out.println("✓ SUCCESS");

        // Operation 2: Foreclosure - PROBLEM with CreditCardLoan!
        System.out.print("2. Attempting foreclosure... ");
        try {
            loan.foreCloseLoan();
            System.out.println("✓ SUCCESS");
        } catch (UnsupportedOperationException e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            System.out.println("   >>> LSP VIOLATION DETECTED! <<<");
        }

        // Operation 3: Repayment - PROBLEM with CreditCardLoan!
        System.out.print("3. Attempting repayment... ");
        try {
            loan.doRepayment(500);
            System.out.println("✓ SUCCESS");
        } catch (UnsupportedOperationException e) {
            System.out.println("✗ FAILED: " + e.getMessage());
            System.out.println("   >>> LSP VIOLATION DETECTED! <<<");
        }
    }

    /**
     * Demonstrates how LoanClosureService fails with CreditCardLoan
     * Shows that we cannot substitute LoanPayment with CreditCardLoan
     */
    private static void demonstrateLoanClosureService() {
        System.out.println("Testing LoanClosureService with different loans:");

        // Test with HomeLoan - should work
        System.out.print("\n1. Creating LoanClosureService with HomeLoan... ");
        LoanClosureService homeLoanService = new LoanClosureService(new HomeLoan());
        System.out.println("Service created");

        System.out.print("   Executing foreclosure... ");
        try {
            homeLoanService.foreCloseLoan();
            System.out.println("✓ Operation successful");
        } catch (Exception e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }

        // Test with CreditCardLoan - should FAIL
        System.out.print("\n2. Creating LoanClosureService with CreditCardLoan... ");
        LoanClosureService creditCardService = new LoanClosureService(new CreditCardLoan());
        System.out.println("Service created");

        System.out.print("   Executing foreclosure... ");
        try {
            creditCardService.foreCloseLoan();
            System.out.println("✓ Operation successful");
        } catch (UnsupportedOperationException e) {
            System.out.println("✗ Operation failed: " + e.getMessage());
            System.out.println("   >>> LSP VIOLATION: Cannot substitute CreditCardLoan for LoanPayment <<<");
        }

        // Show polymorphic behavior issue
        System.out.println("\n3. Polymorphic behavior test:");
        LoanPayment[] loanArray = {new HomeLoan(), new CreditCardLoan(), new HomeLoan()};

        for (int i = 0; i < loanArray.length; i++) {
            System.out.print("   Loan " + (i + 1) + " (" + loanArray[i].getClass().getSimpleName() + "): ");
            if (loanArray[i] instanceof CreditCardLoan) {
                System.out.println("Cannot use in LoanClosureService - LSP VIOLATION!");
            } else {
                System.out.println("Can use in LoanClosureService - OK");
            }
        }
    }
}

    /**
     * Detailed analysis of why this design violates Liskov Substitution Principle
     *
     *
        ============================================================

        DETAILED ANALYSIS OF LSP VIOLATION:
        ==================================================

        1. THE CONTRACT PROBLEM:
        • Interface LoanPayment defines a contract with 3 methods:
        - doPayment()
        - foreCloseLoan()
        - doRepayment()
        • This contract promises that ALL implementations support ALL methods

        2. THE IMPLEMENTATION REALITY:
        • HomeLoan: Implements ALL 3 methods correctly
        • CreditCardLoan: Throws exceptions for 2/3 methods
        • CreditCardLoan does NOT fulfill the complete contract

        3. THE SUBSTITUTION FAILURE:
        • LSP states: Objects of superclass should be replaceable
        with objects of subclass without breaking the system
        • In our code: LoanClosureService expects ANY LoanPayment
        • Reality: CreditCardLoan BREAKS LoanClosureService
        • Therefore: CreditCardLoan is NOT substitutable for LoanPayment

        4. THE DETECTION PROBLEM:
        • Compiler doesn't detect this issue
        • The problem only appears at RUNTIME as exceptions
        • This makes the system fragile and unpredictable

        5. THE REAL-WORLD CONSEQUENCES:
        • Need for instanceof checks (code smell)
        • Unexpected runtime exceptions
        • Difficult to add new loan types
        • Harder to test and maintain

        6. THE SOLUTION:
        • Apply Interface Segregation Principle (ISP)
        • Create smaller, focused interfaces
        • Each interface should represent a specific capability
        • Classes implement only interfaces they truly support

        ==================================================

        CONCLUSION: This design VIOLATES Liskov Substitution Principle
        because CreditCardLoan cannot be substituted for LoanPayment
        without breaking the system's expected behavior.
     */

