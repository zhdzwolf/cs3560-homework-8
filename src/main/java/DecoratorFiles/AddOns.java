package DecoratorFiles;

public class AddOns {

    public static abstract class Toppings implements FoodItems {
        protected FoodItems items;

        public Toppings(FoodItems foodItems) {
            this.items = foodItems;
        }

        public String getDescription() {
            return items.getDescription();
        }

        public double getPrice() {
            return items.getPrice();
        }
    }

    public static class Ketchup extends Toppings {
        public Ketchup(FoodItems foodItems) {
            super(foodItems);
        }

        public String getDescription() {
            return items.getDescription() + " + Ketchup";
        }

        public double getPrice() {
            return items.getPrice() + 0.25;
        }
    }

    public static class Mustard extends Toppings {
        public Mustard(FoodItems foodItems) {
            super(foodItems);
        }

        public String getDescription() {
            return items.getDescription() + " + Mustard";
        }

        public double getPrice() {
            return items.getPrice() + 0.25;
        }
    }

    public static class Mayo extends Toppings {
        public Mayo(FoodItems foodItems) {
            super(foodItems);
        }

        public String getDescription() {
            return items.getDescription() + " + Mayo";
        }

        public double getPrice() {
            return items.getPrice() + 0.25;
        }
    }

    public static class Cheese extends Toppings {
        public Cheese(FoodItems foodItems) {
            super(foodItems);
        }

        public String getDescription() {
            return items.getDescription() + " + Cheese";
        }

        public double getPrice() {
            return items.getPrice() + 0.25;
        }
    }

    public static class Onions extends Toppings {
        public Onions(FoodItems foodItems) {
            super(foodItems);
        }

        public String getDescription() {
            return items.getDescription() + " + Onions";
        }

        public double getPrice() {
            return items.getPrice() + 0.25;
        }
    }

}
