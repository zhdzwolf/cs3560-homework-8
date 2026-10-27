package DecoratorFiles;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
    private final List<FoodItems> items = new ArrayList<>();

    public void addItem(FoodItems item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0.0;

        for (FoodItems item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public void displayOrder() {
        System.out.println("Customer Order:");

        for (FoodItems item : items) {
            System.out.printf(
                    "%s: $%.2f%n",
                    item.getDescription(),
                    item.getPrice()
            );
        }

        System.out.printf(
                "Subtotal: $%.2f%n",
                calculateTotal()
        );
    }
}

