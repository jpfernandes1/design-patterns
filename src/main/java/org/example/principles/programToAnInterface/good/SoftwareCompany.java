package org.example.principles.programToAnInterface.good;

import java.util.ArrayList;
import java.util.List;

public class SoftwareCompany extends Company {

    @Override
    protected List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();

        // Concrete creation is delegated to subclasses
        employees.add(new Developer());
        employees.add(new Tester());

        return employees;
    }
}
