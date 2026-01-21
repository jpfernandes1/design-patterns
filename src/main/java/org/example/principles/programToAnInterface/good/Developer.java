package org.example.principles.programToAnInterface.good;

public class Developer implements Employee {

    @Override
    public void work() {
        System.out.println("Developer is writing code.");
    }
}
