package com.pluralsight.deli;

public abstract class Topping {
    protected final String name;
    protected final boolean isExtra;

    protected Topping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() { return name; }
    public boolean isExtra() { return isExtra; }

    // Size-aware price (sandwich size in inches)
    public abstract double getPrice(int sizeInches);
}