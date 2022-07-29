package com.coffeemachine;

public class Order {
    private DrinkTypeEnum drinkType;
    private Integer sugar;
    private Integer paidAmount;

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
}
