package org.example.solid.openClosed;

/*
    That means that any class or interface you create should be closed to further modification.
    If there are other functionality you need to add, it necessary to create a new class
    and extend from it.

    So, the classes should be Open to extension and closed to modifications;
    This is a good example of how we should do. Take a look at BadCalculator to see how we shouldn't.

    On the parameters we add an Operation type, so we can call all the classes (and its methods) that extend from it ;

 */

public class Calculator {
    public int calculateNumber(int number1, int number2, Operation operation) {
        return operation.perform(number1, number2);
    }
}
