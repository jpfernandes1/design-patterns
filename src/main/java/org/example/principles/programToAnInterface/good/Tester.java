package org.example.principles.programToAnInterface.good;

public class Tester implements Employee {

    @Override
    public void work() {
        System.out.println("Tester is testing the application.");
    }
}
