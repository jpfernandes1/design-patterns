package org.example.principles.solid.liskovSubstitution.bad;

/*

     Liskov principle

     Whenever you're creating a inheritance relationship both class should be interchangeable/replaceable;

    This is loan closure service which is responsible
    to close the loan before its actual due date.

    Now since credit card is not supporting foreclosure
    it will throw exception which is wrong in design where
    we are unable to substitute subtype with super type.
    That is violations of Liskov substitution rule.
    Solution to this lets segregate the method in different super types
    and make supertype substitutable at any given time.

 */
public class LoanClosureService {

    private LoanPayment loanPayment;

    public LoanClosureService(LoanPayment loanPayment) {
        this.loanPayment = loanPayment;
    }

    public void foreCloseLoan(){
        loanPayment.foreCloseLoan();
    }
}
