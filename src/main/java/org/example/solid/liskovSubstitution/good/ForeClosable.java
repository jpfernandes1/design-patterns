package org.example.solid.liskovSubstitution.good;

/**
 * Interface for loans that allow early repayment.
 * Only loans that actually support this operation should implement it.
 */
public interface ForeClosable {
    void foreCloseLoan();
}
