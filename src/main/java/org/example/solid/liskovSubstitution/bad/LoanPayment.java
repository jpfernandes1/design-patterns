package org.example.solid.liskovSubstitution.bad;

/*

    This is loan interface responsible for payment related operations on loan account
    LoanPayment implemented by actual loans like Home Loan, Credit Card Loan etc.
    For credit card/personal loan which is unsecured foreclosure and repayment is not allowed

        The current design violates the Liskov Substitution Principle because:

    The LoanPayment interface defines an overly generic contract – forcing all implementations
    to support operations that are not applicable to all loan types.

    CreditCardLoan breaks the superclass/interface contract – throwing an UnsupportedOperationException
    in 2 of the 3 methods, indicating that it cannot be replaced by LoanPayment without causing errors.

    The LoanClosureService client expects inconsistent behavior – upon receiving a CreditCardLoan,
    the foreCloseLoan() method will throw an exception, breaking the expected flow.

    In the current code, CreditCardLoan is NOT replaceable by LoanPayment in the context of LoanClosureService.

 */
public interface LoanPayment {

    public void doPayment(int amount);
    public void foreCloseLoan();
    public void doRepayment(int amount);
}
