package org.example.principles.encapsulateWhatVaries.methodLevel.better;

/**
 * Specialized class for tax calculations
 * Encapsulates all tax rules and calculations
 */
public class TaxCalculator {

    /**
     * Gets tax rate based on country
     * @param country Country code
     * @return Tax rate as decimal
     */
    public double getTaxRate(String country) {
        switch (country.toUpperCase()) {
            case "US":
                return 0.07;  // US sales tax
            case "EU":
                return 0.20;  // European VAT
            case "BR":
                return 0.17;  // Brazilian tax
            case "MX":
                return 0.16;  // Mexican tax
            case "JP":
                return 0.10;  // Japanese consumption tax
            case "CA":
                return getCanadianTaxRate();  // Special method for Canada
            default:
                return 0.0;
        }
    }

    /**
     * Calculates tax amount for a given subtotal and country
     * @param subtotal Order subtotal
     * @param country Country code
     * @return Tax amount
     */
    public double calculateTax(double subtotal, String country) {
        double taxRate = getTaxRate(country);
        return subtotal * taxRate;
    }

    /**
     * Complex logic example - encapsulated in its own method
     * Could include database queries, province-specific rules, etc.
     */
    private double getCanadianTaxRate() {
        // In real implementation, this could include:
        // - Database queries for tax rates
        // - Province-specific calculations
        // - Product-specific tax rules
        return 0.13; // Simplified GST/HST rate
    }

    /**
     * Checks if a country has tax support
     * @param country Country code
     * @return true if tax calculation is supported for this country
     */
    public boolean isTaxSupportedCountry(String country) {
        String[] supportedCountries = {"US", "EU", "BR", "MX", "JP", "CA"};
        for (String supported : supportedCountries) {
            if (supported.equalsIgnoreCase(country)) {
                return true;
            }
        }
        return false;
    }
}