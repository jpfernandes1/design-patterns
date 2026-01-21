package org.example.principles.encapsulateWhatVaries.methodLevel.better;

import org.example.principles.encapsulateWhatVaries.methodLevel.utils.LineItem;

import java.util.List;

/**
 * Specialized class for order validation
 * Demonstrates Single Responsibility Principle
 */
public class OrderValidator {

    /**
     * Validates order items and country
     * @param items List of order items
     * @param country Order country
     * @return true if order is valid
     */
    public boolean validateOrder(List<LineItem> items, String country) {
        if (items == null || items.isEmpty()) {
            System.out.println("ERROR: Order has no items");
            return false;
        }

        if (country == null || country.trim().isEmpty()) {
            System.out.println("ERROR: Country not specified");
            return false;
        }

        for (LineItem item : items) {
            if (!validateLineItem(item)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Validates individual line item
     * @param item Line item to validate
     * @return true if item is valid
     */
    private boolean validateLineItem(LineItem item) {
        if (item.getPrice() < 0) {
            System.out.println("ERROR: Item price cannot be negative");
            return false;
        }

        if (item.getQuantity() <= 0) {
            System.out.println("ERROR: Item quantity must be positive");
            return false;
        }

        if (item.getPrice() * item.getQuantity() > 100000) {
            System.out.println("WARNING: Item value exceeds limit");
        }

        return true;
    }

    /**
     * Validates if country is supported
     * @param country Country code
     * @return true if country is supported
     */
    public boolean validateCountry(String country) {
        String[] supportedCountries = {"US", "EU", "BR", "MX", "JP", "CA", "AU", "GB"};
        for (String supported : supportedCountries) {
            if (supported.equalsIgnoreCase(country)) {
                return true;
            }
        }
        System.out.println("WARNING: Country " + country + " might not be supported");
        return false;
    }
}