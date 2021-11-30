package com.salestax.model;

import com.salestax.core.Category;
import com.salestax.core.CategoryEnum;

public class Item {
    public final String name;
    public final Category category;
    //public final CategoryEnum category;
    public final boolean isImported;
    public final float basePrice;
    public float totalPrice;
    public final int quantity;

    public Item(int quantity, String name, Category categoryEnum, boolean isImported, float basePrice) {
        this.name = name;
        this.category = categoryEnum;
        this.isImported = isImported;
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isImported() {
        return isImported;
    }

    public float getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", category=" + category + ", isImported=" + isImported
                        + ", basePrice=" + basePrice + "]";
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
