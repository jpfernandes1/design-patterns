package org.example.principles.solid.dependencyInversion.bad;


/**
 * Let's take similar example which ewe have in Open Closed.
 * Here we are having calculator with add and sub functionality
 * and user is sending choice for it.
 * This operations are called as submodule in the system.
 *
 * Low-level class that implements a specific operation.
 * PROBLEM: It is directly referenced by the high-level class (Calculator),
 * making the system rigid and difficult to modify.
 */
public class AddOperation {
    public int add(int a, int b) {
        return a + b;
    }
}
