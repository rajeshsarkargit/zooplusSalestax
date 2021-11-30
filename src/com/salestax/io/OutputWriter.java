package com.salestax.io;

import com.salestax.processor.IOrder;
import com.salestax.processor.OrderProcessor;

public abstract class OutputWriter implements IOrder{
    
    protected OrderProcessor order;

    public OutputWriter(OrderProcessor order) {
        this.order = order;
    }

    public void process() {
        order.process();
    }

}
