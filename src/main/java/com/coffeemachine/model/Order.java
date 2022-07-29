package com.coffeemachine.model;

import com.coffeemachine.enums.DrinkTypeEnum;

public class Order {
    private DrinkTypeEnum drinkType;
    private Integer sugar;
    private Integer paidAmount;
    private boolean extraHot = false;

    public Order() {}

    public Order(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
        this.sugar = 0;
        this.paidAmount = 0;
    }
    public Order(DrinkTypeEnum drinkType, Integer sugar) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.paidAmount = 0;
    }

    public Order(DrinkTypeEnum drinkType, Integer sugar, Integer paidAmount) {
        this.drinkType = drinkType;
        this.sugar = sugar;
        this.paidAmount = paidAmount;
    }

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }
    public void setDrinkType(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
    }


    public Integer getSugar() {
        return sugar;
    }
    public void setSugar(Integer sugar) {
        this.sugar = sugar;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }
    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }

    public boolean isExtraHot() {
        return extraHot;
    }
    public void setExtraHot(boolean extraHot) {
        this.extraHot = extraHot;
    }

}
