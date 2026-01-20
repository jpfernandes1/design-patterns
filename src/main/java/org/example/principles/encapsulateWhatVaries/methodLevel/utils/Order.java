package org.example.principles.encapsulateWhatVaries.methodLevel.utils;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String country;
    private List<LineItem> lineItems;

    public Order(String country) {
        this.country = country;
        this.lineItems = new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    public List<LineItem> getLineItems() {
        // Returns a copy to protect the encapsulation.
        return new ArrayList<>(lineItems);
    }

    public void addItem(LineItem item) {
        lineItems.add(item);
    }

    public void setCountry(String country) {
        this.country = country;
    }
}