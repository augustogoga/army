package com.solvd.army.model.stock;

public class Drink extends Supply {
    private String drinkType;
    private boolean hasGas;

    public Drink(String productName, int productId, boolean isRefrigerated) {
        super(productName, productId, isRefrigerated);
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public boolean isHasGas() {
        return hasGas;
    }

    public void setHasGas(boolean hasGas) {
        this.hasGas = hasGas;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkType='" + drinkType + '\'' +
                ", hasGas=" + hasGas +
                '}';
    }
}
