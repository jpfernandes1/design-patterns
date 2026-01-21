package org.example.principles.encapsulateWhatVaries;

import org.example.principles.encapsulateWhatVaries.methodLevel.OrderServiceBad;
import org.example.principles.encapsulateWhatVaries.methodLevel.OrderServiceGood;
import org.example.principles.encapsulateWhatVaries.methodLevel.better.DiscountCalculator;
import org.example.principles.encapsulateWhatVaries.methodLevel.better.OrderServiceBetter;
import org.example.principles.encapsulateWhatVaries.methodLevel.better.OrderValidator;
import org.example.principles.encapsulateWhatVaries.methodLevel.better.TaxCalculator;
import org.example.principles.encapsulateWhatVaries.methodLevel.utils.LineItem;
import org.example.principles.encapsulateWhatVaries.methodLevel.utils.Order;

/*
        Evolution Path:
    Level 1: No encapsulation (monolithic method)
    Level 2: Method-level encapsulation (smaller methods)
    Level 3: Class-level encapsulation (specialized classes)

 */

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ENCAPSULATION EVOLUTION: METHOD vs CLASS LEVEL ===\n");

        // Create sample orders
        Order order1 = createSampleOrder("BR");
        Order order2 = createSampleOrder("US");
        Order order3 = createSampleOrder("EU");

        // 1. Test BAD version (no encapsulation)
        System.out.println("\n📉 LEVEL 1: NO ENCAPSULATION");
        System.out.println("=============================");
        OrderServiceBad badService = new OrderServiceBad();
        System.out.println("\nOrder 1 (Brazil):");
        double totalBad = badService.calculateOrderTotal(order1);

        // 2. Test GOOD version (method-level encapsulation)
        System.out.println("\n\n📈 LEVEL 2: METHOD-LEVEL ENCAPSULATION");
        System.out.println("======================================");
        OrderServiceGood goodService = new OrderServiceGood();
        System.out.println("\nOrder 1 (Brazil):");
        double totalGood = goodService.calculateOrderTotal(order1);

        // 3. Test BETTER version (class-level encapsulation)
        System.out.println("\n\n🚀 LEVEL 3: CLASS-LEVEL ENCAPSULATION");
        System.out.println("======================================");
        OrderServiceBetter betterService = new OrderServiceBetter();

        // Test regular order
        System.out.println("\nOrder 1 (Brazil - Regular):");
        double totalBetter1 = betterService.calculateOrderTotal(order1);

        // Test order with promotional code
        System.out.println("\nOrder 2 (USA - with Promo Code):");
        double totalBetter2 = betterService.calculateOrderTotal(order2, "BLACKFRIDAY");

        // Test complex order
        System.out.println("\nOrder 3 (Europe - Complex):");
        Order complexOrder = createComplexOrder("EU");
        double totalBetter3 = betterService.calculateOrderTotal(complexOrder);

        // 4. Demonstrate class reusability
        System.out.println("\n\n🔄 CLASS REUSABILITY DEMONSTRATION");
        System.out.println("==================================");

        // Use TaxCalculator independently
        TaxCalculator taxCalc = new TaxCalculator();
        System.out.println("\nTax Calculator (Standalone):");
        System.out.println("Tax rate for Japan: " + (taxCalc.getTaxRate("JP") * 100) + "%");
        System.out.println("Tax for $1000 in Brazil: $" + taxCalc.calculateTax(1000, "BR"));
        System.out.println("Is Canada supported? " + taxCalc.isTaxSupportedCountry("CA"));

        // Use DiscountCalculator independently
        DiscountCalculator discountCalc = new DiscountCalculator();
        System.out.println("\nDiscount Calculator (Standalone):");
        System.out.println("Discount for $750: $" + discountCalc.calculateDiscount(750));
        System.out.println("Discount for $1200 with promo: $" +
                discountCalc.applyPromotionalDiscount(1200, "CYBERMONDAY"));
        System.out.println("Is 'SUMMER25' valid? " + discountCalc.isValidPromoCode("SUMMER25"));

        // Use OrderValidator independently
        OrderValidator validator = new OrderValidator();
        System.out.println("\nOrder Validator (Standalone):");
        System.out.println("Is Australia supported? " + validator.validateCountry("AU"));

        // 5. Test error cases
        System.out.println("\n\n⚠️ ERROR HANDLING DEMONSTRATION");
        System.out.println("==============================");
        try {
            Order invalidOrder = new Order("");
            invalidOrder.addItem(new LineItem("Test", -10, 1));
            betterService.calculateOrderTotal(invalidOrder);
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught error: " + e.getMessage());
        }

        // 6. Summary comparison
        System.out.println("\n\n📊 ENCAPSULATION LEVELS COMPARISON");
        System.out.println("==================================");
        System.out.println("1. NO ENCAPSULATION:");
        System.out.println("   - One giant method (30+ lines)");
        System.out.println("   - Mixed responsibilities");
        System.out.println("   - Hard to test and maintain");

        System.out.println("\n2. METHOD-LEVEL ENCAPSULATION:");
        System.out.println("   - Multiple small methods (5-10 lines each)");
        System.out.println("   - Single responsibility per method");
        System.out.println("   - Easier to test individual logic");

        System.out.println("\n3. CLASS-LEVEL ENCAPSULATION:");
        System.out.println("   - Separate classes for each responsibility");
        System.out.println("   - High cohesion, low coupling");
        System.out.println("   - Easy to test (unit tests per class)");
        System.out.println("   - Promotes code reuse");
        System.out.println("   - Follows Single Responsibility Principle");

        // 7. Test individual components
        System.out.println("\n\n🧪 COMPONENT TESTING DEMONSTRATION");
        System.out.println("==================================");
        testIndividualComponents();
    }

    /**
     * Creates a sample order for testing
     * @param country Country for the order
     * @return Sample order
     */
    private static Order createSampleOrder(String country) {
        Order order = new Order(country);
        order.addItem(new LineItem("Laptop", 2500.00, 1));
        order.addItem(new LineItem("Mouse", 50.00, 2));
        order.addItem(new LineItem("Keyboard", 150.00, 1));
        return order;
    }

    /**
     * Creates a complex order for testing
     * @param country Country for the order
     * @return Complex order
     */
    private static Order createComplexOrder(String country) {
        Order order = new Order(country);
        order.addItem(new LineItem("Gaming PC", 3500.00, 1));
        order.addItem(new LineItem("Monitor 4K", 800.00, 2));
        order.addItem(new LineItem("Gaming Chair", 500.00, 1));
        order.addItem(new LineItem("Headset", 200.00, 1));
        return order;
    }

    /**
     * Tests individual components independently
     */
    private static void testIndividualComponents() {
        // Test TaxCalculator
        TaxCalculator taxCalc = new TaxCalculator();
        System.out.println("\nTax Calculator Tests:");
        System.out.println("US Tax on $100: $" + taxCalc.calculateTax(100, "US"));
        System.out.println("EU Tax on $100: $" + taxCalc.calculateTax(100, "EU"));

        // Test DiscountCalculator
        DiscountCalculator discountCalc = new DiscountCalculator();
        System.out.println("\nDiscount Calculator Tests:");
        System.out.println("Discount on $300: $" + discountCalc.calculateDiscount(300));
        System.out.println("Discount on $600: $" + discountCalc.calculateDiscount(600));
        System.out.println("Discount on $1500: $" + discountCalc.calculateDiscount(1500));

        // Test OrderValidator
        OrderValidator validator = new OrderValidator();
        Order testOrder = createSampleOrder("US");
        System.out.println("\nOrder Validator Tests:");
        System.out.println("Valid order: " + validator.validateOrder(testOrder.getLineItems(), "US"));
    }
}