package com.lanchanote;
public class Lanche {
    private int code;
    private String name;
    private double price;
    private int amount;
    private String imagePath;

    public Lanche(int code, String name, double price, int amount, String imagePath) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.imagePath = imagePath;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getamount() {
        return this.amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
    public String toString() {
        return
            " code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            ", price='" + getPrice() + "'" +
            ", amount='" + getamount() + "'";
    }
}
