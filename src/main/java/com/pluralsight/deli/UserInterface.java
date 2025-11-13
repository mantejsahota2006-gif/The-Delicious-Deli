package com.pluralsight.deli;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        while (true) {
            System.out.println("=== DELI-cious POS ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if ("0".equals(choice)) {
                System.out.println("Goodbye!");
                return;
            } else if ("1".equals(choice)) {
                runOrderFlow();
            } else {
                System.out.println("Invalid choice.\n");
            }
        }
    }

    private void runOrderFlow() {
        Order order = new Order();
        while (true) {
            System.out.println("\n--- Order Screen --- (newest items show first at checkout)");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();

            switch (c) {
                case "0" -> { System.out.println("Order canceled.\n"); return; }
                case "1" -> addSandwichScreen(order);
                case "2" -> addDrinkScreen(order);
                case "3" -> addChipsScreen(order);
                case "4" -> { checkoutScreen(order); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void addSandwichScreen(Order order) {
        try {
            System.out.print("Bread (white/wheat/rye/wrap): ");
            String bread = scanner.nextLine().trim().toLowerCase();

            System.out.print("Size (4/8/12): ");
            int size = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Toasted? (y/n): ");
            boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("y");

            Sandwich s = new Sandwich(size, bread, toasted);

            // Quick demo topping prompts (expand as needed)
            System.out.print("Add meat (comma separated, blank for none). Options: steak, ham, salami, roast beef, chicken, bacon\n> ");
            String meats = scanner.nextLine().trim();
            if (!meats.isEmpty()) {
                for (String m : meats.split(",")) {
                    String name = m.trim();
                    if (!name.isEmpty()) {
                        System.out.print("Extra " + name + "? (y/n): ");
                        boolean extra = scanner.nextLine().trim().equalsIgnoreCase("y");
                        s.addTopping(new Meat(name, extra));
                    }
                }
            }

            System.out.print("Add cheese (comma separated, blank for none). Options: american, provolone, cheddar, swiss\n> ");
            String cheeses = scanner.nextLine().trim();
            if (!cheeses.isEmpty()) {
                for (String ch : cheeses.split(",")) {
                    String name = ch.trim();
                    if (!name.isEmpty()) {
                        System.out.print("Extra " + name + "? (y/n): ");
                        boolean extra = scanner.nextLine().trim().equalsIgnoreCase("y");
                        s.addTopping(new Cheese(name, extra));
                    }
                }
            }

            System.out.print("Add regular toppings (comma separated, blank for none). Examples: lettuce,onions,peppers,tomatoes,jalapenos,cucumbers,pickles,guacamole,mushrooms\n> ");
            String regs = scanner.nextLine().trim();
            if (!regs.isEmpty()) {
                for (String r : regs.split(",")) {
                    String name = r.trim();
                    if (!name.isEmpty()) {
                        s.addTopping(new RegularToppings(name, false));
                    }
                }
            }

            System.out.print("Add sauces (comma separated, blank for none). Examples: mayo,mustard,ketchup,ranch,thousand island,vinaigrette\n> ");
            String sauces = scanner.nextLine().trim();
            if (!sauces.isEmpty()) {
                for (String a : sauces.split(",")) {
                    String name = a.trim();
                    if (!name.isEmpty()) {
                        s.addTopping(new Sauce(name));
                    }
                }
            }

            order.addSandwich(s);
            System.out.println("Sandwich added: " + s.displaySandwich());

        } catch (Exception e) {
            System.out.println("Could not add sandwich: " + e.getMessage());
        }
    }

    private void addDrinkScreen(Order order) {
        try {
            System.out.print("Drink size (Small/Medium/Large): ");
            String size = scanner.nextLine().trim();
            System.out.print("Flavor (e.g., Coke, Sprite, Water): ");
            String flavor = scanner.nextLine().trim();

            Drink d = new Drink(size, flavor);
            order.addOther(d);
            System.out.println("Added: " + d);
        } catch (Exception e) {
            System.out.println("Could not add drink: " + e.getMessage());
        }
    }

    private void addChipsScreen(Order order) {
        System.out.print("Add chips for $1.50? (y/n): ");
        boolean yes = scanner.nextLine().trim().equalsIgnoreCase("y");
        if (yes) {
            order.addOther(new Chips(true));
            System.out.println("Added: Chips $1.50");
        } else {
            System.out.println("No chips added.");
        }
    }

    private void checkoutScreen(Order order) {
        // Show summary
        System.out.println("\n--- ORDER SUMMARY ---");
        System.out.println(order.toReceiptString());

        System.out.print("Confirm? (y to save receipt / any key to cancel): ");
        String conf = scanner.nextLine().trim();
        if (conf.equalsIgnoreCase("y")) {
            try {
                var path = ReceiptWriter.saveOrderReceipt(order);
                System.out.println("Saved receipt: " + path.toAbsolutePath());
            } catch (IOException e) {
                System.out.println("Failed to save receipt: " + e.getMessage());
            }
        } else {
            System.out.println("Checkout canceled. Returning to home.\n");
        }
    }
}
