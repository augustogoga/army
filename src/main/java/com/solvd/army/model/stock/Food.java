package com.solvd.army.model.stock;

public class Food extends Supply {
    private String foodType;
    private String isSpicy;

    public Food(String productName, int productId, boolean isRefrigerated) {
        super(productName, productId, isRefrigerated);
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getIsSpicy() {
        return isSpicy;
    }

    public void setIsSpicy(String isSpicy) {
        this.isSpicy = isSpicy;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodType='" + foodType + '\'' +
                ", isSpicy='" + isSpicy + '\'' +
                '}';
    }
}
