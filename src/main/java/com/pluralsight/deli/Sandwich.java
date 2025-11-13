package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Sandwich {
    private int size;                 // 4, 8, or 12
    private String breadType;         // white, wheat, rye, wrap
    private boolean toasted;
    private final List<Topping> toppings = new ArrayList<>();

    public Sandwich(int size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
    }
    public void addTopping(Topping t) {
        if (t != null) toppings.add(t);
    }
    public double calculatePrice() {
        double total = PriceList.baseSandwichPrice(size);
        for (Topping t : toppings) total += t.getPrice(size);
        return total;
    }
    public String displaySandwich() {
        StringJoiner tj = new StringJoiner(", ");
        for (Topping t : toppings) {
            tj.add(t.getName() + (t.isExtra() ? " (extra)" : ""));
        }
        return String.format(
                "%d\" %s%s | Toppings: [%s] | $%.2f",
                size,
                breadType,
                toasted ? " (toasted)" : "",
                tj.length() == 0 ? "none" : tj.toString(),
                calculatePrice()
        );
    }
    // Getters
    public int getSize() { return size; }
    public String getBreadType() { return breadType; }
    public boolean isToasted() { return toasted; }
    public List<Topping> getToppings() { return List.copyOf(toppings); }
}

