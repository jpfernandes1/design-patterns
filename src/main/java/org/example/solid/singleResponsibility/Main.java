package org.example.solid.singleResponsibility;

import java.math.BigDecimal;

/*

    The Single Responsibility Principle (SRP), one of the SOLID principles, suggests that a class should have only one
    reason to change. This means that all methods and properties within that class should be closely tied to that singular
    responsibility, ensuring that the entire class is cohesive and focuses on a single task or functionality.

    At the method level, the Single Responsibility Principle manifests itself through the idea that a method should do
    one thing and do it well. Methods should be well encapsulated, cohesive, and have a clear and specific purpose.
    If a method starts performing several unrelated tasks, it becomes a strong candidate for being restructured or
    divided into smaller, more focused methods.

    Therefore:
    - Classes should have a singular responsibility, such as managing users, processing payments, or generating reports.
    - Methods should be cohesive and perform a single, well-defined operation, contributing to the overall responsibility of the class.

    The main focus of the SRP is on the class, as it is the fundamental unit of organization and change in object-oriented programming.

       But why is this important?

       Because the more responsibilities a class has, the more often it will have to be modified,
       and the more coupled the parts of the application become.
 */

public class Main {
    public static void main(String[] args) {

        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("John");
        account.setTotalAmount(BigDecimal.valueOf(10000));
        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);

        TransactionOperations transactionOperations = new TransactionOperations();
        transactionOperations.deposit(123, BigDecimal.valueOf(120));
    }
}
