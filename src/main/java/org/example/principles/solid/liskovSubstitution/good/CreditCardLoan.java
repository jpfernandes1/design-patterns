package org.example.principles.solid.liskovSubstitution.good;

/**
 * CreditCardLoan only implements LoanPayment because:
 * - It only supports payments
 * - It does NOT support early repayment (credit cards have revolving credit limits)
 * - It does NOT support repayment in the same sense as traditional loans
 */
public class CreditCardLoan implements LoanPayment {

    @Override
    public void doPayment(int amount) {
        System.out.println("CreditCardLoan: Payment of $" + amount + " completed. Available limit restored.");
    }
}
