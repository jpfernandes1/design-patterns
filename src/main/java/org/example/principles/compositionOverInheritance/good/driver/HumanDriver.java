package org.example.principles.compositionOverInheritance.good.driver;

/**
 * Human-controlled navigation.
 */
public class HumanDriver implements Driver {

    @Override
    public void navigate(String destination) {
        System.out.println("Human driver navigating to " + destination + ".");
    }
}
