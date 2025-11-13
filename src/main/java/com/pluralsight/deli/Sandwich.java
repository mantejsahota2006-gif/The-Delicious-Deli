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
}
