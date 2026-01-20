package org.example.principles.solid.liskovSubstitution.good;

/**
 * Example of a service that only processes payments.
 * Can accept any type of LoanPayment (HomeLoan, CreditCardLoan, etc.)
 * as they all guarantee support for doPayment().
 */
public class PaymentProcessorService {

    private final LoanPayment loanPayment;

    public PaymentProcessorService(LoanPayment loanPayment) {
        this.loanPayment = loanPayment;
    }

    public void processPayment(int amount) {
        loanPayment.doPayment(amount);
    }
}

/*

    // Correct usage - LSP respected
    HomeLoan homeLoan = new HomeLoan();

    CreditCardLoan creditCardLoan = new CreditCardLoan();

    / Settlement service only accepts loans that are ForeClosable
    LoanClosureService closureService = new LoanClosureService(homeLoan);

    closureService.foreCloseLoan(); // Works correctly

    // Payment service accepts any LoanPayment
    PaymentProcessorService paymentService1 = new PaymentProcessorService(homeLoan);

    PaymentProcessorService paymentService2 = new PaymentProcessorService(creditCardLoan);

    / Compilation error - prevents LSP violation at compile time
    // LoanClosureService invalidService = new LoanClosureService(creditCardLoan); // DOES NOT COMPILE

 */