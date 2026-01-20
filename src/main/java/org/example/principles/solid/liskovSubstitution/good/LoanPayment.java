package org.example.principles.solid.liskovSubstitution.good;

/**
 * Basic interface for all loan types that support payments.
 * Segregates the minimum liability common to all loans.
 */
public interface LoanPayment {
    void doPayment(int amount);
}
