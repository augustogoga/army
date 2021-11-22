package com.solvd.army.model.stock;

public abstract class Supply {
    private String productName;
    private int productId;
    private boolean isRefrigerated;

    public Supply() {

    }

    public Supply(String productName, int productId, boolean isRefrigerated) {
        this.productName = productName;
        this.productId = productId;
        this.isRefrigerated = isRefrigerated;

    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isRefrigerated() {
        return isRefrigerated;
    }

    public void setRefrigerated(boolean refrigerated) {
        isRefrigerated = refrigerated;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", isRefrigerated=" + isRefrigerated +
                '}';
    }
}
