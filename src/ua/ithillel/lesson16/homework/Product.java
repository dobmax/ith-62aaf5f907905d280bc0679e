package ua.ithillel.lesson16.homework;

import java.time.LocalDate;

public class Product {
    private Type type;
    private float price;
    private boolean isSale;
    private LocalDate created;

    public Product(Type type, float price, boolean isSale) {
        this.type = type;
        this.price = price;
        this.isSale = isSale;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public enum Type {
        BOOK,
    }
}
