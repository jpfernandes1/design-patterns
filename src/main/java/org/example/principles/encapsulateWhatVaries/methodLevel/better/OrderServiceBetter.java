package org.example.principles.encapsulateWhatVaries.methodLevel.better;

import org.example.principles.encapsulateWhatVaries.methodLevel.utils.LineItem;
import org.example.principles.encapsulateWhatVaries.methodLevel.utils.Order;

import java.util.List;

/**
 * Order service using class-level encapsulation
 * Demonstrates composition over inheritance principle
 */
public class OrderServiceBetter {

    // Composition: Service HAS-A tax calculator, discount calculator, validator
    private TaxCalculator taxCalculator;
    private DiscountCalculator discountCalculator;
    private OrderValidator orderValidator;

    /**
     * Constructor with dependency initialization
     */
    public OrderServiceBetter() {
        this.taxCalculator = new TaxCalculator();
        this.discountCalculator = new DiscountCalculator();
        this.orderValidator = new OrderValidator();
    }

    /**
     * Alternative constructor for dependency injection (testing)
     * @param taxCalculator Tax calculator instance
     * @param discountCalculator Discount calculator instance
     * @param orderValidator Order validator instance
     */
    public OrderServiceBetter(TaxCalculator taxCalculator,
                              DiscountCalculator discountCalculator,
                              OrderValidator orderValidator) {
        this.taxCalculator = taxCalculator;
        this.discountCalculator = discountCalculator;
        this.orderValidator = orderValidator;
    }

    /**
     * Calculates order total without promo code
     * @param order Order to calculate
     * @return Total order amount
     */
    public double calculateOrderTotal(Order order) {
        return calculateOrderTotal(order, null);
    }

    /**
     * Calculates order total with optional promo code
     * @param order Order to calculate
     * @param promoCode Optional promotional code
     * @return Total order amount
     */
    public double calculateOrderTotal(Order order, String promoCode) {
        // 1. Validation phase
        if (!orderValidator.validateOrder(order.getLineItems(), order.getCountry())) {
            throw new IllegalArgumentException("Invalid order");
        }

        // 2. Subtotal calculation
        double subtotal = calculateSubtotal(order.getLineItems());

        // 3. Tax calculation (delegated to TaxCalculator)
        double tax = taxCalculator.calculateTax(subtotal, order.getCountry());

        // 4. Discount calculation (delegated to DiscountCalculator)
        double discount;
        if (promoCode != null && discountCalculator.isValidPromoCode(promoCode)) {
            discount = discountCalculator.applyPromotionalDiscount(subtotal, promoCode);
        } else {
            discount = discountCalculator.calculateDiscount(subtotal);
        }

        // 5. Final total calculation
        double total = subtotal + tax - discount;

        // 6. Display order summary
        displayOrderSummary(order, subtotal, tax, discount, total, promoCode);

        return total;
    }

    /**
     * Calculates subtotal from line items
     * @param items List of line items
     * @return Subtotal amount
     */
    private double calculateSubtotal(List<LineItem> items) {
        double subtotal = 0;
        for (LineItem item : items) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        return subtotal;
    }

    /**
     * Displays formatted order summary
     * @param order Order object
     * @param subtotal Order subtotal
     * @param tax Tax amount
     * @param discount Discount amount
     * @param total Final total
     * @param promoCode Promotional code used
     */
    private void displayOrderSummary(Order order, double subtotal, double tax,
                                     double discount, double total, String promoCode) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("ORDER SUMMARY");
        System.out.println("=".repeat(40));
        System.out.printf("Country: %s\n", order.getCountry());
        System.out.printf("Items: %d\n", order.getLineItems().size());

        for (LineItem item : order.getLineItems()) {
            System.out.printf("  %s\n", item);
        }

        System.out.println("-".repeat(40));
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        System.out.printf("Tax: $%.2f\n", tax);

        if (promoCode != null) {
            System.out.printf("Discount (Promo: %s): $%.2f\n", promoCode, discount);
        } else {
            System.out.printf("Discount: $%.2f\n", discount);
        }

        System.out.println("-".repeat(40));
        System.out.printf("TOTAL: $%.2f\n", total);
        System.out.println("=".repeat(40));
    }

    /**
     * Calculates only tax for an order
     * @param order Order to calculate tax for
     * @return Tax amount
     */
    public double calculateTaxOnly(Order order) {
        double subtotal = calculateSubtotal(order.getLineItems());
        return taxCalculator.calculateTax(subtotal, order.getCountry());
    }

    /**
     * Calculates only discount for an order
     * @param order Order to calculate discount for
     * @return Discount amount
     */
    public double calculateDiscountOnly(Order order) {
        double subtotal = calculateSubtotal(order.getLineItems());
        return discountCalculator.calculateDiscount(subtotal);
    }

    /**
     * Validates an order
     * @param order Order to validate
     * @return true if order is valid
     */
    public boolean validateOrder(Order order) {
        return orderValidator.validateOrder(order.getLineItems(), order.getCountry());
    }

    /*

        📌 Key Benefits Demonstrated:

    Utility Class Reuse:
    The same Order and LineItem classes from the utils package are reused across all encapsulation levels.

    Advantages of Class-Level Encapsulation:
    1. Single Responsibility Principle (SRP)
        * Each class has one clear responsibility
    2. High Cohesion
        * Related functionality is grouped together
    3. Low Coupling
        * Classes are independent and can evolve separately
    4. Easy Testing
        * Each class can be unit tested independently
    5. Code Reuse
        * Classes can be used in multiple services
    6. Better Maintainability
        * Changes to tax rules only affect TaxCalculator
        * Changes to discount rules only affect DiscountCalculator



     */
}