package org.example.principles.encapsulateWhatVaries.methodLevel.utils;

public class LineItem {
    private double price;
    private int quantity;
    private String description;

    public LineItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: R$%.2f x %d = R$%.2f",
                description, price, quantity, price * quantity);
    }
}