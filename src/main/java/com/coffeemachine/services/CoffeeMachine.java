package com.coffeemachine.services;

import com.coffeemachine.mapper.OrderMapper;
import com.coffeemachine.validator.OrderValidator;
import com.coffeemachine.exceptions.CoffeeMachineException;
import com.coffeemachine.exceptions.MissingMoneyException;
import com.coffeemachine.model.Order;

public class CoffeeMachine {

    private DrinkMaker drinkMaker;

    public CoffeeMachine() {
        drinkMaker = new DrinkMaker();
    }

    public static void main(String[] argv) {}

    public String takeOrder(Order order) {
        try {
            OrderValidator.validateOrder(order);
            String orderAsString = OrderMapper.mapOrderToString(order);

            return drinkMaker.makeDrink(orderAsString);
        } catch (CoffeeMachineException e) {
            return ("M: There Was an error serving your drink: " + e.getMessage());
        } catch (MissingMoneyException e) {
            return ("M: " + e.getMessage());
        }
    }
}

