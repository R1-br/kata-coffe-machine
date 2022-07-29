import com.coffeemachine.services.CoffeeMachine;
import com.coffeemachine.enums.DrinkTypeEnum;
import com.coffeemachine.model.Globals;
import com.coffeemachine.model.Order;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeMachineTests {

    CoffeeMachine coffeeMachine = new CoffeeMachine();

    private static final String expectedNullOrderString = "M: There Was an error serving your drink: Error: Order cannot be null.";
    private static final String expectedNullDrinkTypeString = "M: There Was an error serving your drink: Error: DrinkType cannot be null.";
    private static final String expectedNegativeSugarString = "M: There Was an error serving your drink: Error: You can only have 0, 1 or 2 sugar(s).";
    private static final String expectedTooMuchSugarString = "M: There Was an error serving your drink: Error: You can only have 0, 1 or 2 sugar(s).";
    private static final String expectedNoSugarString = "M: Preparing a chocolate without sugar.";
    private static final String expectedOneSugarString = "M: Preparing a tea with 1 sugar and a stick.";
    private static final String expectedTwoSugarString = "M: Preparing a coffee with 2 sugars and a stick.";
    private static final String expectedNullOrZeroOrNegativePriceString = "M: There Was an error serving your drink: Error: You must pay in order to have a drink.";
    private static final String expectedMissingMoneyString = "M: Missing 30 cents.";
    private static final String expectedOrangeJuiceString = "M: Preparing an orange juice.";
    private static final String expectedExtraHotCoffeeString = "M: Preparing an extra hot coffee without sugar.";
    private static final String expectedExtraHotCoffeeWithSugarString = "M: Preparing an extra hot coffee with 2 sugars and a stick.";

    @Test
    public void testNullOrder() {
        Order order = null;

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNullOrderString, result);

    }

    @Test
    public void testNullDrinkType() {
        Order order = new Order();

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNullDrinkTypeString, result);
    }

    @Test
    public void testOrderNegativeSugar() {
        Order order = new Order(DrinkTypeEnum.COFFEE, -1);

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNegativeSugarString, result);
    }

    @Test
    public void testOrderTooMuchSugar() {
        Order order = new Order(DrinkTypeEnum.COFFEE, 255);

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedTooMuchSugarString, result);
    }

    @Test
    public void testOrderNoSugar() {
        Order order = new Order(DrinkTypeEnum.CHOCOLATE);

        order.setPaidAmount(Globals.CHOCOLATE_PRICE);
        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNoSugarString, result);
    }

    @Test
    public void testOrderOneSugar() {
        Order order = new Order(DrinkTypeEnum.TEA, 1);

        order.setPaidAmount(Globals.TEA_PRICE);
        String result = coffeeMachine.takeOrder(order);
        assertEquals(expectedOneSugarString, result);
    }

    @Test
    public void testOrderTwoSugars() {
        Order order = new Order(DrinkTypeEnum.COFFEE, 2);

        order.setPaidAmount(Globals.COFFEE_PRICE);
        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedTwoSugarString, result);
    }

    @Test
    public void testNullOrZeroOrNegativePrice() {
        Order order = new Order(DrinkTypeEnum.COFFEE, 2);

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNullOrZeroOrNegativePriceString, result);

        order.setPaidAmount(0);
        result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNullOrZeroOrNegativePriceString, result);

        order.setPaidAmount(-2);
        result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNullOrZeroOrNegativePriceString, result);
    }

    @Test
    public void testOrderMissingMoney() {
        Order order = new Order(DrinkTypeEnum.COFFEE, 0, 30);

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedMissingMoneyString, result);
    }

    @Test
    public void testOrderTooMuchMoney() {
        Order order = new Order(DrinkTypeEnum.CHOCOLATE);

        order.setPaidAmount(127);
        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNoSugarString, result);
    }

    @Test
    public void testOrderOrangeJuice() {
        Order order = new Order(DrinkTypeEnum.ORANGE_JUICE);

        order.setPaidAmount(60);
        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedOrangeJuiceString, result);

        order.setSugar(1);
        order.setExtraHot(true);
        result = coffeeMachine.takeOrder(order);

        assertEquals(expectedOrangeJuiceString, result);
    }

    @Test
    public void testOrderExtraHot() {
        Order order = new Order(DrinkTypeEnum.COFFEE);

        order.setPaidAmount(60);
        order.setExtraHot(true);
        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedExtraHotCoffeeString, result);

        order.setSugar(2);
        result = coffeeMachine.takeOrder(order);
        assertEquals(expectedExtraHotCoffeeWithSugarString, result);
    }
}
