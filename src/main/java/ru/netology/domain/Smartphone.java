package ru.netology.domain;

public class Smartphone extends Product {
    protected String mft;

    public Smartphone(int id, String name, int price, String mft) {
        super(id, name, price);
        this.mft = mft;
    }
    public String getMft() {
    return mft;
    }
}
