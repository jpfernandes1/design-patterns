package org.example.principles.encapsulateWhatVaries.methodLevel.better;

/**
 * Specialized class for discount calculations
 * Encapsulates all discount rules and promotions
 */
public class DiscountCalculator {

    private static final double DISCOUNT_THRESHOLD_1 = 500.0;
    private static final double DISCOUNT_THRESHOLD_2 = 1000.0;
    private static final double DISCOUNT_RATE_1 = 0.05;  // 5% discount
    private static final double DISCOUNT_RATE_2 = 0.10;  // 10% discount

    /**
     * Calculates discount based on order subtotal
     * @param subtotal Order subtotal
     * @return Discount amount
     */
    public double calculateDiscount(double subtotal) {
        if (subtotal > DISCOUNT_THRESHOLD_2) {
            return subtotal * DISCOUNT_RATE_2;
        } else if (subtotal > DISCOUNT_THRESHOLD_1) {
            return subtotal * DISCOUNT_RATE_1;
        }
        return 0.0;
    }

    /**
     * Applies promotional discount on top of regular discount
     * @param subtotal Order subtotal
     * @param promoCode Promotional code
     * @return Total discount amount
     */
    public double applyPromotionalDiscount(double subtotal, String promoCode) {
        double discount = calculateDiscount(subtotal);

        // Additional discount based on promo code
        if ("BLACKFRIDAY".equals(promoCode)) {
            discount += subtotal * 0.15;  // Additional 15%
        } else if ("CYBERMONDAY".equals(promoCode)) {
            discount += subtotal * 0.20;  // Additional 20%
        }

        // Ensure discount doesn't exceed 50% of subtotal
        return Math.min(discount, subtotal * 0.5);
    }

    /**
     * Validates promotional code
     * @param promoCode Promotional code to validate
     * @return true if promo code is valid
     */
    public boolean isValidPromoCode(String promoCode) {
        // In real application, this would query a database
        String[] validCodes = {"BLACKFRIDAY", "CYBERMONDAY", "WELCOME10", "SUMMER25"};
        for (String valid : validCodes) {
            if (valid.equals(promoCode)) {
                return true;
            }
        }
        return false;
    }
}