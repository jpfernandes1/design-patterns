package org.example.principles.compositionOverInheritance.good.driver;
/**
 * Strategy interface for navigation behavior.
 *
 * This hierarchy represents WHO is driving the transport.
 */
public interface Driver {
    void navigate(String destination);
}
