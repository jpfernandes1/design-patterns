package org.example.principles.compositionOverInheritance.good.driver;

/**
 * Autonomous navigation.
 */
public class RobotDriver implements Driver {

    @Override
    public void navigate(String destination) {
        System.out.println("Robot driver navigating autonomously to " + destination + ".");
    }
}
