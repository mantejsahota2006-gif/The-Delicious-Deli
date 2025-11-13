package com.pluralsight.deli;

public final class PriceList {
    private PriceList() {
    }

    // Sandwich base prices by size
    public static double baseSandwichPrice(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> throw new IllegalArgumentException("Invalid size: " + sizeInches);
        };
    }
}