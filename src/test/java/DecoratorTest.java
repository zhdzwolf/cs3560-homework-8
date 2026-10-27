import DecoratorFiles.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {
    @Test
    void testBurgerBasePrice() {
        FoodItems burger = new FoodTypes.Burger();

        assertEquals(5.50, burger.getPrice());
        assertEquals("Burger", burger.getDescription());
    }

    @Test
    void testFriesBasePrice() {
        FoodItems fries = new FoodTypes.Fries();

        assertEquals(1.75, fries.getPrice());
        assertEquals("Fries", fries.getDescription());
    }

    @Test
    void testHotDogBasePrice() {
        FoodItems hotDog = new FoodTypes.HotDog();

        assertEquals(2.5, hotDog.getPrice());
        assertEquals("Hot Dog", hotDog.getDescription());
    }

    @Test
    void testCheeseDecorator() {
        FoodItems burger = new AddOns.Cheese(new FoodTypes.Burger());

        assertEquals(5.75, burger.getPrice());
        assertEquals("Burger + Cheese", burger.getDescription());
    }

    @Test
    void testKetchupDecorator() {
        FoodItems burger = new AddOns.Ketchup(new FoodTypes.Burger());

        assertEquals(5.75, burger.getPrice());
        assertEquals("Burger + Ketchup", burger.getDescription());
    }

    @Test
    void testOnionsDecorator() {
        FoodItems burger = new AddOns.Onions(new FoodTypes.Burger());

        assertEquals(5.75, burger.getPrice());
        assertEquals("Burger + Onions", burger.getDescription());
    }

    @Test
    void testMultipleToppings() {
        FoodItems burger =
                new AddOns.Onions(new AddOns.Cheese(new FoodTypes.Burger()));

        assertEquals(6.0, burger.getPrice());
        assertEquals(
                "Burger + Cheese + Onions",
                burger.getDescription()
        );
    }

    @Test
    void testToppingsOnDifferentFoodItems() {
        FoodItems fries = new AddOns.Ketchup(new FoodTypes.Fries());
        FoodItems hotDog = new AddOns.Cheese(new FoodTypes.HotDog());

        assertEquals(2.0, fries.getPrice());
        assertEquals(2.75, hotDog.getPrice());
    }

    @Test
    void testRegularCustomerGetsNoDiscount() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.REGULAR);

        assertEquals(100.00, loyalty.applyDiscount(100.00));
    }

    @Test
    void testSilverCustomerGetsFivePercentDiscount() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.SILVER);

        assertEquals(95.00, loyalty.applyDiscount(100.00));
    }

    @Test
    void testGoldCustomerGetsTenPercentDiscount() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.GOLD);

        assertEquals(90.00, loyalty.applyDiscount(100.00));
    }

    @Test
    void testPlatinumCustomerGetsFifteenPercentDiscount() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.PLATINUM);

        assertEquals(85.00, loyalty.applyDiscount(100.00));
    }

    @Test
    void testDiscountOnZeroTotal() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.GOLD);

        assertEquals(0.00, loyalty.applyDiscount(0.00));
    }

    @Test
    void testGetLevel() {
        LoyaltyStatus loyalty =
                new LoyaltyStatus(LoyaltyStatus.Level.GOLD);

        assertEquals(LoyaltyStatus.Level.GOLD, loyalty.getLevel());
    }

    @Test
    void testEmptyOrderTotal() {
        CustomerOrder order = new CustomerOrder();

        assertEquals(0.00, order.calculateTotal());
    }

    @Test
    void testOrderWithOneItem() {
        CustomerOrder order = new CustomerOrder();
        order.addItem(new FoodTypes.Burger());

        assertEquals(5.50, order.calculateTotal());
    }

    @Test
    void testOrderWithMultipleItems() {
        CustomerOrder order = new CustomerOrder();

        order.addItem(new FoodTypes.Burger());
        order.addItem(new FoodTypes.Fries());
        order.addItem(new FoodTypes.HotDog());

        assertEquals(9.75, order.calculateTotal());
    }

    @Test
    void testOrderWithToppings() {
        CustomerOrder order = new CustomerOrder();

        FoodItems burger = new AddOns.Cheese(new AddOns.Onions(new FoodTypes.Burger()));
        FoodItems fries = new AddOns.Ketchup(new FoodTypes.Fries());

        order.addItem(burger);
        order.addItem(fries);

        assertEquals(8.0, order.calculateTotal());
    }

    @Test
    void testAddingItemsUpdatesTotal() {
        CustomerOrder order = new CustomerOrder();

        order.addItem(new FoodTypes.Burger());
        assertEquals(5.50, order.calculateTotal());

        order.addItem(new FoodTypes.Fries());
        assertEquals(7.25, order.calculateTotal());
    }

}
