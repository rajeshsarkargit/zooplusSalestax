package com.salestax.core;

import com.salestax.model.Item;

public abstract class TaxDecorator implements Tax<Item>{

    protected Tax<Item> tax;
    
    public float compute(Item item) {
        return tax.compute(item);
    }
}
