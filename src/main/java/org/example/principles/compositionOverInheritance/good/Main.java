package org.example.principles.compositionOverInheritance.good;

import org.example.principles.compositionOverInheritance.good.driver.HumanDriver;
import org.example.principles.compositionOverInheritance.good.driver.RobotDriver;
import org.example.principles.compositionOverInheritance.good.engine.CombustionEngine;
import org.example.principles.compositionOverInheritance.good.engine.ElectricEngine;

/*

    🧠 Central message

        Inheritance combines behaviors. Composition separates them.

        This example:

        eliminates subclass explosion
        maintains encapsulation
        allows independent variation
        is a classic example of Strategy + DIP

 */
public class Main {

    public static void main(String[] args) {

        Transport transport = new Transport(
                new ElectricEngine(),
                new HumanDriver()
        );

        transport.deliver("Warehouse A", "Electronics");

        // Swap behavior at runtime — impossible with inheritance explosion
        transport.setEngine(new CombustionEngine());
        transport.setDriver(new RobotDriver());

        transport.deliver("Warehouse B", "Furniture");
    }
}
