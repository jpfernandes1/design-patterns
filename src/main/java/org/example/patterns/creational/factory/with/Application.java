package org.example.patterns.creational.factory.with;

/*

    ✅ Advantages of the Factory Method

        ✔ Removes if/else and instanceof statements
        ✔ Centralizes creation, not usage
        ✔ Allows extension without modification
        ✔ Client code depends only on abstractions
        ✔ Facilitates testing and mocking
        ✔ Each class has a clear responsibility

    ⚠️ Real disadvantages (important!)

        ❌ More classes in the project
        ❌ Steeper learning curve
        ❌ May seem like overengineering if:
            -There are only 1 or 2 types
            - There is no forecast for growth

    💡 Practical rule:

        Use the Factory Method when object creation varies or will vary.

    🧠 Signs that you NEED this pattern

        ✔ Too many if's (type == ...)
        ✔ Frequent use of instanceof
        ✔ Code breaking when adding new features
        ✔ Classes know too many details
        ✔ Difficulty testing

 */

public class Application {

    public static void main(String[] args) {

        Logistics logistics = new RoadLogistics();
        logistics.planDelivery(100);

        logistics = new SeaLogistics();
        logistics.planDelivery(300);
    }
}