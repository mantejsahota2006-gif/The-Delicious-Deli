package com.pluralsight.deli;

public final class PriceList {
    private PriceList() {
    }

    // Sandwich base prices
    public static double baseSandwichPrice(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> throw new IllegalArgumentException("Invalid size: " + sizeInches);
        };
    }

    // Premium topping add-ons meat & cheese
    public static double meatAddOn(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 1.00;
            case 8 -> 2.00;
            case 12 -> 3.00;
            default -> 0.0;
        };
    }
}