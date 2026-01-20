package org.example.principles.encapsulateWhatVaries.methodLevel;

import org.example.principles.encapsulateWhatVaries.methodLevel.utils.LineItem;
import org.example.principles.encapsulateWhatVaries.methodLevel.utils.Order;

import java.util.List;

// ✅ GOOD VERSION: With method-level encapsulation
public class OrderServiceGood {

    // MAIN METHOD - Clean and organized
    public double calculateOrderTotal(Order order) {
        // Each step in its own method.
        double subtotal = calculateSubtotal(order.getLineItems());
        double tax = calculateTax(subtotal, order.getCountry());
        double discount = calculateDiscount(subtotal);
        double total = subtotal + tax - discount;

        // It also encapsulates the display
        displayOrderSummary(subtotal, tax, discount, total);

        return total;
    }

    // ✅ ENCAPSULATED METHOD #1: Single Responsibility
    private double calculateSubtotal(List<LineItem> items) {
        double subtotal = 0;
        for (LineItem item : items) {
            subtotal += item.getPrice() * item.getQuantity();
        }
        return subtotal;
    }

    // ✅ ENCAPSULATED METHOD #2: Isolated tax logic
    private double calculateTax(double subtotal, String country) {
        double taxRate = getTaxRate(country);
        return subtotal * taxRate;
    }

    // ✅ ENCAPSULATED METHOD #3: Centralized Fees
    private double getTaxRate(String country) {
        switch (country) {
            case "US": return 0.07;
            case "EU": return 0.20;
            case "BR": return 0.17;
            case "MX": return 0.16;
            case "JP": return 0.10;
            default:   return 0.0;
        }
    }

    // ✅ ENCAPSULATED METHOD #4: Isolated discount rules
    private double calculateDiscount(double subtotal) {
        if (subtotal > 1000) {
            return subtotal * 0.10;  // 10% discount for orders over 1000
        } else if (subtotal > 500) {
            return subtotal * 0.05;  // 5% discount for orders over 500
        }
        return 0;
    }

    // ✅ ENCAPSULATED METHOD #5: Formatted Display
    private void displayOrderSummary(double subtotal, double tax,
                                     double discount, double total) {
        System.out.println("\n=== ORDER SUMMARY ===");
        System.out.printf("Subtotal: R$%.2f\n", subtotal);
        System.out.printf("Taxes: R$%.2f\n", tax);
        System.out.printf("Discount: R$%.2f\n", discount);
        System.out.printf("TOTAL: R$%.2f\n", total);
        System.out.println("=========================");
    }

    // BONUS: Public methods for reuse
    public double calculateTaxOnly(Order order) {
        double subtotal = calculateSubtotal(order.getLineItems());
        return calculateTax(subtotal, order.getCountry());
    }

    public double calculateDiscountOnly(Order order) {
        double subtotal = calculateSubtotal(order.getLineItems());
        return calculateDiscount(subtotal);
    }
}