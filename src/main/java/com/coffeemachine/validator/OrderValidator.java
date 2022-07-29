package com.coffeemachine.validator;

import com.coffeemachine.exceptions.CoffeeMachineException;
import com.coffeemachine.model.Order;

public class OrderValidator {

    static public void validateOrder(Order order) throws CoffeeMachineException {
        if (order == null) {
            throw new CoffeeMachineException("Error: Order cannot be null.");
        }

        if (order.getDrinkType() == null) {
            throw new CoffeeMachineException("Error: DrinkType cannot be null.");
        }

        if(order.getSugar() != null) {
            if (order.getSugar() < 0 || order.getSugar() > 2) {
                throw new CoffeeMachineException("Error: You can only have 0, 1 or 2 sugar(s).");
            }
        }

        if (order.getPaidAmount() == null || order.getPaidAmount() <= 0) {
            throw  new CoffeeMachineException("Error: You must pay in order to have a drink.");
        }
    }

    static public void validateStringOrder(String orderAsString) throws CoffeeMachineException {
        if (orderAsString == null) {
            throw new CoffeeMachineException("Error: Order cannot be null.");
        }

        String[] orderAsArray = orderAsString.split(":");

        if (orderAsArray == null) {
            throw new CoffeeMachineException("Error: Unable to parse order string.");
        }
        if (orderAsArray[0] == null || orderAsArray[0].isEmpty()) {
            throw new CoffeeMachineException("Error: Null Drink Code.");
        }

        if (orderAsArray.length == 3 && !orderAsArray[1].isEmpty()) {
            try {
                Integer sugar = Integer.parseInt(orderAsArray[1]);

                if (sugar < 0 || sugar > 2) {
                    throw new CoffeeMachineException("Error: You can only have 0, 1 or 2 sugar(s).");
                } else if (orderAsArray[2].isEmpty() || !orderAsArray[2].equals("0")) {
                    throw new CoffeeMachineException("Error: Unable to parse order string: the stick must have the value '0' when sugar is ordered.");
                }
            } catch (NumberFormatException e) {
                throw new CoffeeMachineException("Error: Incorrect sugar format.");
            }
        }
    }
}
