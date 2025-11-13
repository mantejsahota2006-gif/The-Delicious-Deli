package com.pluralsight.deli;

public class Cheese extends Topping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sizeInches) {
        // Cheese is premium: base cheese add-on (+ extra add-on if extra)
        double price = PriceList.cheeseAddOn(sizeInches);
        if (isExtra) price += PriceList.extraCheeseAddOn(sizeInches);
        return price;
    }
}
