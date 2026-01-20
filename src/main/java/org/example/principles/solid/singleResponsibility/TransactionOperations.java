package org.example.principles.solid.singleResponsibility;

import java.math.BigDecimal;

public class TransactionOperations {

    // This is good as it does transactions and at right place
    public void deposit(int accountNumber, BigDecimal amount) {
        //Getting account details it is job of account operations
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().add(amount));
    }

    public void withdraw(int accountNumber, BigDecimal amount) {
        AccountOperations accountOperations = new AccountOperations();
        Account account = accountOperations.getAccount(accountNumber);
        account.setTotalAmount(account.getTotalAmount().subtract(amount));
    }
}
