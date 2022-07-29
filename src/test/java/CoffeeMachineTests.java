import com.coffeemachine.CoffeeMachine;
import com.coffeemachine.DrinkTypeEnum;
import com.coffeemachine.Order;
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

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedNoSugarString, result);
    }

    @Test
    public void testOrderOneSugar() {
        Order order = new Order(DrinkTypeEnum.TEA, 1);

        String result = coffeeMachine.takeOrder(order);
        assertEquals(expectedOneSugarString, result);
    }

    @Test
    public void testOrderTwoSugars() {
        Order order = new Order(DrinkTypeEnum.COFFEE, 2);

        String result = coffeeMachine.takeOrder(order);

        assertEquals(expectedTwoSugarString, result);
    }
}
