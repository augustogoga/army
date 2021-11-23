package com.solvd.army.model.stock;

public class Ammunition extends Supply {
    private String ammoType;
    private boolean fmj;

    public Ammunition(String productName, int productId) {
        super(productName, productId, false);
    }

    public String getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(String ammoType) {
        this.ammoType = ammoType;
    }

    public boolean isFmj() {
        return fmj;
    }

    public void setFmj(boolean fmj) {
        this.fmj = fmj;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "ammoType='" + ammoType + '\'' +
                ", fmj=" + fmj +
                '}';
    }
}
