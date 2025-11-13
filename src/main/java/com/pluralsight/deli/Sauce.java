package com.pluralsight.deli;

public class Sauce extends Topping {
    public Sauce(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(int sizeInches) {
        // Sauces are included
        return 0.0;
    }
}
