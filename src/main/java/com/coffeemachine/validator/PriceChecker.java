package com.coffeemachine.validator;

public class PriceChecker {

    public static boolean checkPrice(Integer paidAmount, Integer requiredAmount) {
        if (paidAmount < requiredAmount) {
            return false;
        }
        return true;
    }
}
