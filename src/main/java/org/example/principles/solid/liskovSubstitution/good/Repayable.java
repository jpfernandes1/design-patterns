package org.example.principles.solid.liskovSubstitution.good;

/**
 * Interface for loans that allow repayment.
 * Only loans that actually support this operation should implement it.
 */
public interface Repayable {
    void doRepayment(int amount);
}