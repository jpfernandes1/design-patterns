package org.example.principles.solid.liskovSubstitution.good;

/**
 * Specialized service for early loan repayment.
 * Now relies solely on ForeClosable, ensuring that any received object
 * supports the early repayment operation.
 *
 * Liskov Substitution Principle respected: Any implementation of ForeClosable
 * can override the interface without causing unexpected behavior.
 */
public class LoanClosureService {

    private final ForeClosable foreClosableLoan;

    public LoanClosureService(ForeClosable foreClosableLoan) {
        this.foreClosableLoan = foreClosableLoan;
    }

    public void foreCloseLoan() {
        foreClosableLoan.foreCloseLoan();
    }
}
