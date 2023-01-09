package ru.netology.domain;

public class Smartphone extends Product {
    protected String mft;

    public Smartphone(int id, String name, int price, String mft) {
        super(id, name, price);
        this.mft = mft;
    }
    public  int getId() {
        return  id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
