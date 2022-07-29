package com.coffeemachine.services;

import com.coffeemachine.mapper.OrderMapper;
import com.coffeemachine.validator.OrderValidator;
import com.coffeemachine.exceptions.CoffeeMachineException;
import com.coffeemachine.model.Order;

public class DrinkMaker {

    public String makeDrink(String orderAsString) throws CoffeeMachineException {
        try {
            String response = new String("M: Preparing a");

            OrderValidator.validateStringOrder(orderAsString);
            Order order = OrderMapper.mapStringToOrder(orderAsString);

            switch (order.getDrinkType()) {
                case COFFEE:
                    response = response.concat((order.isExtraHot() ? "n extra hot" : "") + " coffee with");
                    break;
                case TEA:
                    response = response.concat((order.isExtraHot() ? "n extra hot" : "") + " tea with");
                    break;
                case CHOCOLATE:
                    response = response.concat((order.isExtraHot() ? "n extra hot" : "") + " chocolate with");
                    break;
                case ORANGE_JUICE:
                    response = response.concat("n orange juice.");
                    return response;
                default:
            }

            if (order.getSugar() == 0) {
                response = response.concat("out sugar.");
            } else {
                response = response.concat(" " + order.getSugar().toString() + " sugar" + ((order.getSugar() == 1) ? " " : "s ") + "and a stick.");
            }

            return (response);
        } catch (CoffeeMachineException e) {
            throw e;
        }
    }
}
