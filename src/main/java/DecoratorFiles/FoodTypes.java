package DecoratorFiles;

public class FoodTypes {

    public class Burger implements FoodItems {
        @Override
        public String getDescription() {
            return "Burger";
        }
        @Override
        public double getPrice() {
            return 5.50;
        }
    }

    public class Fries implements FoodItems {
        @Override
        public String getDescription() {
            return "Fries";
        }
        @Override
        public double getPrice() {
            return 1.75;
        }
    }

    public class Pizza implements FoodItems {
        @Override
        public String getDescription() {
            return "Pizza";
        }
        @Override
        public double getPrice() {
            return 1.5;
        }
    }

    public class HotDog implements FoodItems {
        @Override
        public String getDescription() {
            return "Hot Dog";
        }
        @Override
        public double getPrice() {
            return 2.5;
        }
    }

    public class Slurpee implements FoodItems {
        @Override
        public String getDescription() {
            return "Slurpee";
        }
        @Override
        public double getPrice() {
            return 1.0;
        }
    }

}
