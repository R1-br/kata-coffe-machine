package com.coffeemachine;

public class DrinkMaker {

    public String makeDrink(String orderAsString) throws CoffeeMachineException {
        try {
            String response = new String("M: Preparing a");

            OrderValidator.validateStringOrder(orderAsString);
            Order order = OrderMapper.mapStringToOrder(orderAsString);

            switch (order.getDrinkType()) {
                case COFFEE:
                    response = response.concat(" coffee with");
                    break;
                case TEA:
                    response = response.concat(" tea with");
                    break;
                case CHOCOLATE:
                    response = response.concat(" chocolate with");
                    break;
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
