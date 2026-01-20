package org.example.principles.solid.openClosed;

public class Main {
    public static void main(String[] args) {
        // instantiate calculator
        Calculator calculator = new Calculator();

        // Tests
        int num1 = 10;
        int num2 = 5;

        Operation add = new AddOperation();
        int result = calculator.calculateNumber(num1, num2, add);
        System.out.println(num1 + " + " + num2 + " = " + result);

        Operation subtract = new SubstractOperation();
        int result2 = calculator.calculateNumber(num1, num2, subtract);
        System.out.println(num1 + " - " + num2 + " = " + result2);


        // Adding a NEW operation without modifying the Calculator!
        System.out.println("\n=== New Operation ===");

        // Power
        Operation power = new PowerOperation();
        result = calculator.calculateNumber(num1, num2, power);
        System.out.println(num1 + " ^ " + num2 + " = " + result);
    }

    // Internal class to demonstrate extensibility - It should be a new class
    static class PowerOperation implements Operation {
        @Override
        public int perform(int number1, int number2) {
            return (int) Math.pow(number1, number2);
        }
    }
}