package org.example.principles.programToAnInterface.good;

import java.util.List;

/*
    Why an Abstract class and not an interface?

    Interfaces:
    should not contain complex business logic
    do not maintain state
    do not model "standard flow + variation" well

    Abstract classes:
    allow reusable code
    allow protecting parts of the algorithm
    allow for forcing extension points

    Rule of thumb: If you have common behavior* plus variations, use an abstract class.

    * What is "common behavior"?

       It is an executable, reusable, semantically correct code within the domain and shared by more
       than one implementation that:
          - Appears in more than one implementation
          - Does exactly the same thing
          - Should not be the responsibility of whoever is using the class
          - Can be reused without violating the domain

        In other words:
        It's not what the object does.
        It's how some of that work is always done.

        Example:

            protected abstract void format();

            - Common behavior:
            protected void fetchData() {
                System.out.println("Fetching data from database");
            }

            - Common behavior:
            protected void export() {
                System.out.println("Exporting report");
            }

 */

public abstract class Company {

    // Template method that defines the business flow
    public void runBusiness() {
        List<Employee> employees = createEmployees();

        for (Employee employee : employees) {
            employee.work();
        }
    }

    // Factory Method
    // Subclasses decide which employees will be created
    protected abstract List<Employee> createEmployees();
}
