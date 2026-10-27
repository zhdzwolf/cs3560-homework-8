import DecoratorFiles.*;

public class DecoratorDriver {
    public static void main(String[] args) {

        // like the whole menu
        FoodItems burger = new FoodTypes.Burger();
        burger = new AddOns.Cheese(burger);
        burger = new AddOns.Onions(burger);

        FoodItems fries = new FoodTypes.Fries();
        fries = new AddOns.Cheese(fries);
        fries = new AddOns.Mayo(fries);
        fries = new AddOns.Ketchup(fries);

        FoodItems hotdog = new FoodTypes.HotDog();
        hotdog = new AddOns.Ketchup(hotdog);
        hotdog = new AddOns.Mustard(hotdog);

        FoodItems pizza = new FoodTypes.Pizza();

        FoodItems slurpee =  new FoodTypes.Slurpee();

        // make da orda
        CustomerOrder order = new CustomerOrder();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotdog);
        order.addItem(slurpee);
        order.addItem(pizza);

        order.displayOrder();

        // apply discount
        LoyaltyStatus status = new LoyaltyStatus(LoyaltyStatus.Level.GOLD);

        double subtotal = order.calculateTotal();
        double finalTotal = status.applyDiscount(subtotal);

        System.out.println("Status: " + status.getLevel());
        System.out.printf("Discount: $%.2f%n", (subtotal - finalTotal));
        System.out.printf("Total: $%.2f%n", finalTotal);

    }
}
