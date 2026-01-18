package org.example.solid.liskovSubstitution.good;

import java.util.Arrays;
import java.util.List;

/**
 * The fundamental differences :
 *
 * Poor Design (violates LSP):
 *
 * This COMPILES, but CRASHES at runtime!
 * LoanClosureService service = new LoanClosureService(new CreditCardLoan());
 * service.foreCloseLoan(); // 💥 UnsupportedOperationException!
 *
 * Compiles ✓ Runtime failure ✗ (LSP violation!)
 *
 * Good Design (respects LSP):
 *
 * This DOESN'T EVEN COMPILE - error detected early!
 * LoanClosureService service = new LoanClosureService(new CreditCardLoan());
 * / ^ COMPILER ERROR: CreditCardLoan is not ForeClosable
 *
 * Doesn't compile ✓ (Compile-time protection!) Zero runtime failures ✓
 *
 * Demonstration class showing Liskov Substitution Principle compliance
 * This example shows how the system works correctly when using
 * properly segregated interfaces that respect LSP
 */
public class LSPCompliantDemo {

    public static void main(String[] args) {
        System.out.println("=== LISKOV SUBSTITUTION PRINCIPLE COMPLIANT DEMONSTRATION ===\n");

        // Scenario 1: HomeLoan with all capabilities
        System.out.println("SCENARIO 1: HomeLoan (implements all relevant interfaces)");
        HomeLoan homeLoan = new HomeLoan();
        executeLoanOperations(homeLoan);

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Scenario 2: CreditCardLoan with specific capabilities
        System.out.println("SCENARIO 2: CreditCardLoan (implements only applicable interfaces)");
        CreditCardLoan creditCardLoan = new CreditCardLoan();
        executeLoanOperations(creditCardLoan);

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Demonstrate services with proper dependencies
        System.out.println("SCENARIO 3: Services with proper interface dependencies");
        demonstrateCompliantServices();

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Demonstrate polymorphic behavior without violations
        System.out.println("SCENARIO 4: Safe polymorphic behavior");
        demonstrateSafePolymorphism();
    }

    /**
     * Executes operations on loans using proper type checking
     * Demonstrates LSP compliance by only calling methods that are guaranteed to exist
     */
    private static void executeLoanOperations(Object loan) {
        System.out.println("Loan type: " + loan.getClass().getSimpleName());

        // Operation 1: Payment - only if loan supports it
        if (loan instanceof LoanPayment) {
            System.out.print("1. Processing payment... ");
            ((LoanPayment) loan).doPayment(1000);
            System.out.println("✓ SUCCESS");
        } else {
            System.out.println("1. Processing payment... ✗ NOT SUPPORTED");
        }

        // Operation 2: Foreclosure - only if loan supports it
        if (loan instanceof ForeClosable) {
            System.out.print("2. Attempting foreclosure... ");
            ((ForeClosable) loan).foreCloseLoan();
            System.out.println("✓ SUCCESS");
        } else {
            System.out.println("2. Attempting foreclosure... ✗ NOT SUPPORTED (Expected behavior)");
        }

        // Operation 3: Repayment - only if loan supports it
        if (loan instanceof Repayable) {
            System.out.print("3. Attempting repayment... ");
            ((Repayable) loan).doRepayment(500);
            System.out.println("✓ SUCCESS");
        } else {
            System.out.println("3. Attempting repayment... ✗ NOT SUPPORTED (Expected behavior)");
        }
    }

    /**
     * Demonstrates how services work correctly with proper interfaces
     * Shows that each service accepts only what it can handle
     */
    private static void demonstrateCompliantServices() {
        System.out.println("Testing services with proper interface dependencies:");

        // Create instances
        HomeLoan homeLoan = new HomeLoan();
        CreditCardLoan creditCardLoan = new CreditCardLoan();

        // 1. Payment Processor Service - accepts any LoanPayment
        System.out.println("\n1. PaymentProcessorService:");

        System.out.print("   With HomeLoan... ");
        PaymentProcessorService homePaymentService = new PaymentProcessorService(homeLoan);
        homePaymentService.processPayment(1000);
        System.out.println("✓ Works correctly");

        System.out.print("   With CreditCardLoan... ");
        PaymentProcessorService creditCardPaymentService = new PaymentProcessorService(creditCardLoan);
        creditCardPaymentService.processPayment(500);
        System.out.println("✓ Works correctly");

        // 2. Loan Closure Service - accepts only ForeClosable loans
        System.out.println("\n2. LoanClosureService:");

        System.out.print("   With HomeLoan... ");
        LoanClosureService homeClosureService = new LoanClosureService(homeLoan);
        homeClosureService.foreCloseLoan();
        System.out.println("✓ Works correctly");

        System.out.print("   With CreditCardLoan... ");
        try {
            // This won't compile - CreditCardLoan doesn't implement ForeClosable!
            // LoanClosureService creditCardClosureService = new LoanClosureService(creditCardLoan);
            System.out.println("✗ Won't compile - Type safety prevents LSP violation!");
        } catch (Exception e) {
            System.out.println("✗ Compiler prevents this error at compile time");
        }

        // 3. Loan Repayment Service (hypothetical) - accepts only Repayable loans
        System.out.println("\n3. LoanRepaymentService (hypothetical):");

        System.out.print("   With HomeLoan... ");
        // Hypothetical service that processes repayments
        processRepaymentIfSupported(homeLoan);
        System.out.println("✓ Works correctly");

        System.out.print("   With CreditCardLoan... ");
        processRepaymentIfSupported(creditCardLoan);
        System.out.println("✓ Correctly identified as not supported");
    }

    /**
     * Demonstrates safe polymorphic behavior without runtime exceptions
     */
    private static void demonstrateSafePolymorphism() {
        System.out.println("Demonstrating type-safe polymorphic collections:\n");

        // Collection of LoanPayment objects - both HomeLoan and CreditCardLoan can be here
        List<LoanPayment> allLoans = Arrays.asList(
                new HomeLoan(),
                new CreditCardLoan(),
                new HomeLoan(),
                new CreditCardLoan()
        );

        System.out.println("Processing payments for all loans:");
        for (int i = 0; i < allLoans.size(); i++) {
            System.out.print("  Loan " + (i + 1) + " (" +
                    allLoans.get(i).getClass().getSimpleName() + "): ");
            allLoans.get(i).doPayment(100 * (i + 1));
            System.out.println("✓ Payment processed successfully");
        }

        // Collection of ForeClosable objects - only HomeLoan can be here
        System.out.println("\nProcessing foreclosures for ForeClosable loans:");
        List<ForeClosable> foreClosableLoans = Arrays.asList(
                new HomeLoan(),
                new HomeLoan()
                // CreditCardLoan cannot be added here - compiler prevents it!
        );

        for (int i = 0; i < foreClosableLoans.size(); i++) {
            System.out.print("  Loan " + (i + 1) + " (" +
                    foreClosableLoans.get(i).getClass().getSimpleName() + "): ");
            foreClosableLoans.get(i).foreCloseLoan();
            System.out.println("✓ Foreclosure processed successfully");
        }

        // Show that we can safely add new loan types
        System.out.println("\nAdding new loan types is safe:");
        System.out.println("  To add a CarLoan:");
        System.out.println("  - If it supports payments: implement LoanPayment");
        System.out.println("  - If it supports foreclosure: implement ForeClosable");
        System.out.println("  - If it supports repayment: implement Repayable");
    }

    /**
     * Helper method to process repayment only if supported
     */
    private static void processRepaymentIfSupported(Object loan) {
        if (loan instanceof Repayable) {
            ((Repayable) loan).doRepayment(1000);
        } else {
            System.out.print("Loan does not support repayment (as expected)");
        }
    }

    /**
     * Key Differences from the Bad Design:
     *
     * No runtime surprises, If something compiles, it works (Prevents bugs even before execution)
     * No Runtime Exceptions: The compliant design never throws UnsupportedOperationException
     * Compile-Time Safety: The compiler prevents passing wrong types to services
     * True Substitutability: Objects can be replaced with their interface types without issues
     * Easy Extensibility: New loan types can be added without modifying existing code
     * No Type Checking: No need for instanceof checks in client code
     *
     *
     * Summary
     *
     * 1. "Pass" ≠ "All operations work"
     * - "Pass" means: the system behaves as expected
     * - CreditCardLoan should not work with LoanClosureService
     * - The compiler prevents this misuse
     * 2. LSP guarantees PREDICTABILITY
     * - No instanceof, no try-catch for expected behavior
     * 3. Clear Contracts: Each interface has a single, clear responsibility and acts like a "promise"
     * - LoanPayment: "I promise I know how to make payments"
     * - ForeClosable: "I promise I can be paid off early"
     * - Repayable: "I promise I accept refunds"
     * 4. "Failure" in good design is actually SUCCESS
     * - When the compiler rejects LoanClosureService(creditCardLoan) is protection, not failure
     *
     * In good design with respected LSP, when you see an object being used,
     * You are 100% certain that it supports all the operations that will be called upon. That is the
     * true "substitutability" that Liskov requires!

     */
}
