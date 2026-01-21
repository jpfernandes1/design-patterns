package org.example.principles.programToAnInterface.bad;

import java.util.ArrayList;
import java.util.List;

/*
    Programming to implementations
 */

public class Company {

    private List<Developer> developers;
    private List<Tester> testers;

    public Company() {
        // Company is responsible for creating concrete employees
        this.developers = new ArrayList<>();
        this.testers = new ArrayList<>();

        developers.add(new Developer());
        testers.add(new Tester());
    }

    public void runBusiness() {
        // Company depends directly on concrete classes
        for (Developer developer : developers) {
            developer.work();
        }

        for (Tester tester : testers) {
            tester.work();
        }
    }
}

/*

    ❌ What's wrong here?

    - Company needs to know all employee types.
    - To add a Designer, you need to:
         1. modify the Company class
         2. recompile
         3. test everything again

    - Low reusability of company logic

 */
