package org.example.solid.liskovSubstitution.good;

/**
 * HomeLoan implements all interfaces because it supports:
 * - Regular payments
 * - Early repayment
 * - Refunds
 */

/*

    Advantages of Corrected Design
- LSP Respected: Each interface can be replaced by its implementations without surprises
- ISP Respected: Segregated interfaces with unique responsibilities
- Maintainability: New loan types can implement only the relevant interfaces
- Clarity: The contract for each interface is explicit and specific
- Robustness: Compiler prevents misuse (does not compile if you try to pass CreditCardLoan to LoanClosureService)

 */
public class HomeLoan implements LoanPayment, ForeClosable, Repayable {

    @Override
    public void doPayment(int amount) {
        System.out.println("HomeLoan: Payment of $" + amount + " made.");
    }

    @Override
    public void foreCloseLoan() {
        System.out.println("HomeLoan: Loan paid off early.");
    }

    @Override
    public void doRepayment(int amount) {
        System.out.println("HomeLoan: Refund of $" + amount + " processed.");
    }
}
