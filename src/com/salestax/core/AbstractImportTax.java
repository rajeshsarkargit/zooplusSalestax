package com.salestax.core;

import com.salestax.model.Item;

public abstract class AbstractImportTax<Item> implements Tax<Item>{
    
    protected Tax<Item> decorated;

    public AbstractImportTax(Tax<Item> decorated) {
        this.decorated = decorated;
    }

    public float compute(Item item) {
        return decorated.compute(item);
    }

}
