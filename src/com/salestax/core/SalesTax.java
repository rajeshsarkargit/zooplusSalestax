package com.salestax.core;

import com.salestax.model.Item;

public class SalesTax extends TaxDecorator{

    public float compute(Item item) {
        return item.basePrice * 0.1f;
    }
}
