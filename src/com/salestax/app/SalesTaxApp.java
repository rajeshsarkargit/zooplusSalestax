package com.salestax.app;

import com.salestax.io.ConsoleOutputWriter;
import com.salestax.io.InputReader;
import com.salestax.processor.OrderProcessor;

/**
 * @author Rajesh
 *sample input 
	Order 1
	1 book at 12.49
	1 music CD at 14.99
	1 chocolate bar at 0.85
	
	Order 2
	1 imported box of chocolates at 10.00
	1 imported bottle of perfume at 47.50
	Stop

 */
public class SalesTaxApp {


    public static void main(String[] args) {

        //OrderProcessor order = new OrderProcessor();
        /*Parser<Map.Entry<Item, Integer>> parser = new OrderConsoleParser();
        parser.stream().forEach(odrMap ->{
        	order.getItems().add(odrMap.getKey());
        	//order.setQuantity(odrMap.getValue());
        });*/ 
        
        InputReader.getOrders().forEach(inputorder->{
        	OrderProcessor orderProcessor = new OrderProcessor();
        	orderProcessor.setItems(inputorder);
        	orderProcessor.process();
        	ConsoleOutputWriter processedOrder = new ConsoleOutputWriter(orderProcessor);
        	processedOrder.write(orderProcessor);
        });
        
        
    }
    
    
}
