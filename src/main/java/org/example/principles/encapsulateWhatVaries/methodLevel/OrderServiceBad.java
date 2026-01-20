package org.example.principles.encapsulateWhatVaries.methodLevel;

import org.example.principles.encapsulateWhatVaries.methodLevel.utils.LineItem;
import org.example.principles.encapsulateWhatVaries.methodLevel.utils.Order;

// ❌ BAD VERSION: No encapsulation
public class OrderServiceBad {

    // GIANT METHOD with multiple responsibilities
    public double calculateOrderTotal(Order order) {
        double subtotal = 0;

        // 1. Calculates subtotal
        for (LineItem item : order.getLineItems()) {
            subtotal += item.getPrice() * item.getQuantity();
        }

        // 2. Applies taxes (MIXED logic)
        String country = order.getCountry();
        double taxRate = 0;

        if (country.equals("US")) {
            taxRate = 0.07;  // USA
        } else if (country.equals("EU")) {
            taxRate = 0.20;  // European
        } else if (country.equals("BR")) {
            taxRate = 0.17;  // ICMS
          //  There could be 20 lines of Brazilian regulations in here...
        } else if (country.equals("MX")) {
            taxRate = 0.16;  // Mexico
        } else {
            taxRate = 0.0;   // No taxes
        }

        double tax = subtotal * taxRate;

        // 3. Apply discounts (also MIXED)
        double discount = 0;
        if (subtotal > 1000) {
            discount = subtotal * 0.10;  // 10% discount
        }

        // 4. Calculate the final total.
        double total = subtotal + tax - discount;

        // 5. Format for display (another responsibility!)
        System.out.println("Subtotal: R$" + String.format("%.2f", subtotal));
        System.out.println("Impostos: R$" + String.format("%.2f", tax));
        System.out.println("Desconto: R$" + String.format("%.2f", discount));
        System.out.println("TOTAL: R$" + String.format("%.2f", total));

        return total;
    }

    // PROBLEM: If you need to use the tax logic elsewhere,
    // you will need to COPY and PASTE this entire code block!
}