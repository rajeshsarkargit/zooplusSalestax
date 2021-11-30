package com.salestax.core;

import java.text.DecimalFormat;
import com.salestax.model.Item;

public class ValueRounder extends Rounder<Item> {



    public ValueRounder(Tax<Item> decorated) {
        super(decorated);
    }

    @Override
    public float compute(Item item) {
        // return super.compute(item);
        float tax = super.compute(item);
        return Float.parseFloat(
                        new DecimalFormat("#0.00").format((Math.ceil((tax * 20.0)) / 20.0)));
    }

}
