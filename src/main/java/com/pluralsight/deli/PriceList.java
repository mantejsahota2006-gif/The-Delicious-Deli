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
    public static double extraMeatAddOn(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 0.50;
            case 8 -> 1.00;
            case 12 -> 1.50;
            default -> 0.0;
        };
    }
    public static double cheeseAddOn(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 0.75;
            case 8 -> 1.50;
            case 12 -> 2.25;
            default -> 0.0;
        };
    }
    public static double extraCheeseAddOn(int sizeInches) {
        return switch (sizeInches) {
            case 4 -> 0.30;
            case 8 -> 0.60;
            case 12 -> 0.90;
            default -> 0.0;
        };
    }
    // Drinks by size
    public static double drinkPrice(String size) {
        String s = size == null ? "" : size.trim().toLowerCase();
        return switch (s) {
            case "small", "s" -> 2.00;
            case "medium", "m" -> 2.50;
            case "large", "l" -> 3.00;
            default -> throw new IllegalArgumentException("Invalid drink size: " + size);
        };
    }

    // Chips (flat)
    public static final double CHIPS_PRICE = 1.50;
}
