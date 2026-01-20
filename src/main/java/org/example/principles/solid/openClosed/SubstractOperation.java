package org.example.principles.solid.openClosed;


/*
    Define a method that will do what this operation need to.
    Later we can just call it on the main class.
    Note: to implement other operations, we can just create
    other classes and extend from operation.
 */

public class SubstractOperation implements Operation {

    @Override
    public int perform(int number1, int number2) {
        return number1 - number2;
    }
}
