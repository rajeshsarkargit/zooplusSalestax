package com.salestax.io;

import java.io.Console;
import java.io.PrintWriter;
import com.salestax.model.Item;
import com.salestax.processor.OrderProcessor;

/**
 * decorator pattern
 *
 */
public class ConsoleOutputWriter extends OutputWriter {

    public ConsoleOutputWriter(OrderProcessor order) {
        super(order);
    }

    @Override
    public void process() {
        order.process();
        write(order);
    }

    public void write(OrderProcessor order) {
        // order to string
        String str = "";
        // order.getItems().stream().forEach();
        for (Item i : order.getItems()) {
            str = str.concat(i.getQuantity() + " " + i.name + " : " + i.getTotalPrice() + "\n");
        }
        str = str.concat("Sales Tax: " + order.getTotalSalesTax() + "\n");
        str = str.concat("Total: " + order.getTotalAmount() + "\n");
        System.out.println(str);
//        Console console = System.console();
//        if (console == null) {
//            System.out.println("No console available");
//            return;
//        }
        /*PrintWriter pw = new PrintWriter(System.out);
        pw.append(str);
        pw.close();*/
    }

}
