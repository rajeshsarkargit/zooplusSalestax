package com.salestax.core;

import com.salestax.model.Item;

public class BaseTax implements Tax<Item>{

    @Override
    public float compute(Item item) {
        return 0;
    }

}
