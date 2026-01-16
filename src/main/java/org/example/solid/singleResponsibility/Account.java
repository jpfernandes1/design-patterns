package org.example.solid.singleResponsibility;

import java.math.BigDecimal;

/*
    This class will be used only to create examples to explain about the principle
 */

public class Account {

    private int accountNumber;
    private String firstName;
    private BigDecimal totalAmount;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
