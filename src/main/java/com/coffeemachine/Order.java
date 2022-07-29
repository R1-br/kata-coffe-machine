package com.coffeemachine;

public class Order {
    private DrinkTypeEnum drinkType;
    private Integer sugar;

    public Order() {}

    public Order(DrinkTypeEnum drinkType, Integer sugar) {
        this.drinkType = drinkType;
        this.sugar = sugar;
    }

    public Order(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
        this.sugar = 0;
    }

    public DrinkTypeEnum getDrinkType() {
        return drinkType;
    }
    public Integer getSugar() {
        return sugar;
    }

    public void setDrinkType(DrinkTypeEnum drinkType) {
        this.drinkType = drinkType;
    }
    public void setSugar(Integer sugar) {
        this.sugar = sugar;
    }
}
