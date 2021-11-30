package com.salestax.core;


public abstract class Rounder<Item> implements Tax<Item> {
    protected Tax<Item> decorated;

    public Rounder(Tax<Item> decorated) {
        this.decorated = decorated;
    }

    public float compute(Item item) {
        return decorated.compute(item);
    }

}
