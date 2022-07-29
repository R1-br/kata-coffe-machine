package com.coffeemachine.mapper;

import com.coffeemachine.validator.PriceChecker;
import com.coffeemachine.enums.DrinkTypeEnum;
import com.coffeemachine.exceptions.CoffeeMachineException;
import com.coffeemachine.exceptions.MissingMoneyException;
import com.coffeemachine.model.Globals;
import com.coffeemachine.model.Order;

public class OrderMapper {

    static public String mapOrderToString(Order order) throws CoffeeMachineException, MissingMoneyException {
        String orderAsString = new String();
        Integer price = 0;

        switch (order.getDrinkType()) {
            case COFFEE:
                price = Globals.COFFEE_PRICE;
                orderAsString = String.valueOf(Globals.COFFEE_CODE);
                break;
            case TEA:
                price = Globals.TEA_PRICE;
                orderAsString = String.valueOf(Globals.TEA_CODE);
                break;
            case CHOCOLATE:
                price = Globals.CHOCOLATE_PRICE;
                orderAsString = String.valueOf(Globals.CHOCOLATE_CODE);
                break;
            case ORANGE_JUICE:
                price = Globals.ORANGE_JUICE_PRICE;
                orderAsString = String.valueOf(Globals.ORANGE_JUICE_CODE);
                break;
            default:
                throw new CoffeeMachineException("Error: Invalid Drink Type");
        }

        if (order.isExtraHot() && order.getDrinkType() != DrinkTypeEnum.ORANGE_JUICE) {
            orderAsString = orderAsString.concat("h");
        }
        orderAsString = orderAsString.concat(":");

        if (!PriceChecker.checkPrice(order.getPaidAmount(), price)) {
            throw new MissingMoneyException("Missing " + (Globals.COFFEE_PRICE - order.getPaidAmount()) +  " cents.");
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
            case Globals.ORANGE_JUICE_CODE:
                order.setDrinkType(DrinkTypeEnum.ORANGE_JUICE);
                break;
            default:
                throw new CoffeeMachineException("Error: Invalid Drink Code.");
        }

        if (order.getDrinkType() != DrinkTypeEnum.ORANGE_JUICE
                && orderAsArray[0].length() > 1
                && orderAsArray[0].charAt(1) == 'h') {
            order.setExtraHot(true);
        }
        if (orderAsArray.length == 1) {
            order.setSugar(0);
        } else {
            order.setSugar(Integer.parseInt(orderAsArray[1]));
        }

        return (order);
    }
}
