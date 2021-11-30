package com.salestax.core;

import com.salestax.model.Item;

public class ImportTax extends AbstractImportTax<Item>{

    public ImportTax(Tax<Item> decorated) {
        super(decorated);
    }

    public float compute(Item item) {
        float tax = super.compute(item);
        return item.basePrice * 0.05f + tax;
    }
    
}
