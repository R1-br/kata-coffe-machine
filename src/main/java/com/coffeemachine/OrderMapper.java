package com.coffeemachine;

import java.util.List;

public class OrderMapper {

    static public String mapOrderToString(Order order) throws CoffeeMachineException {
        String orderAsString = new String();

        switch (order.getDrinkType()) {
            case COFFEE:
                orderAsString = Globals.COFFEE_CODE + ":";
                break;
            case TEA:
                orderAsString = Globals.TEA_CODE + ":";
                break;
            case CHOCOLATE:
                orderAsString = Globals.CHOCOLATE_CODE + ":";
                break;
            default:
                throw new CoffeeMachineException("Error: Invalid Drink Type");
        }

        if (order.getSugar() != null && order.getSugar() > 0) {
            orderAsString = orderAsString.concat(order.getSugar().toString() + ":0");
        } else {
            orderAsString = orderAsString.concat(":");
        }

        return orderAsString;
    }

    static public Order mapStringToOrder(String orderAsString) throws CoffeeMachineException {
        String[] orderAsArray = orderAsString.split(":");
        Order order = new Order();

        switch (orderAsArray[0].charAt(0)) {
            case Globals.COFFEE_CODE:
                order.setDrinkType(DrinkTypeEnum.COFFEE);
                break;
            case Globals.TEA_CODE:
                order.setDrinkType(DrinkTypeEnum.TEA);
                break;
            case Globals.CHOCOLATE_CODE:
                order.setDrinkType(DrinkTypeEnum.CHOCOLATE);
                break;
            default:
                throw new CoffeeMachineException("Error: Invalid Drink Code.");
        }

        if (orderAsArray.length == 1) {
            order.setSugar(0);
        } else {
            order.setSugar(Integer.parseInt(orderAsArray[1]));
        }

        return (order);
    }
}
