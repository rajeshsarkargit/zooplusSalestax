package com.salestax.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.salestax.core.Category;
import com.salestax.core.ProductCategory;
import com.salestax.model.Item;

public class OrderConsoleParser extends ConsoleParser<Map.Entry<Item, Integer>> {

    private ItemIterator itemIterator = new ItemIterator();

    @Override
    public Iterator<Map.Entry<Item, Integer>> iterator() {
        return itemIterator;
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub

    }

    @Override
    public OrderConsoleParser parse() {
        return new OrderConsoleParser();
    }

    @Override
    public Stream<Map.Entry<Item, Integer>> stream() {
        return StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED),
                        false);
    }

    class ItemIterator implements Iterator<Map.Entry<Item, Integer>> {
        private Map.Entry<Item, Integer> current;

        private Map.Entry<Item, Integer> getNextItem() {
            try {
                return OrderConsoleParser.this.nextItem();
            } catch (final Exception e) {
                throw new IllegalStateException(e.getClass().getSimpleName()
                                + " reading next item: " + e.toString(), e);
            }
        }

        @Override
        public boolean hasNext() {
            // if (ConsoleParser.this.isClosed()) {
            // return false;
            // }
            if (this.current == null) {
                this.current = this.getNextItem();
            }

            return this.current != null;
        }

        @Override
        public Map.Entry<Item, Integer> next() {
            // if (ConsoleParser.this.isClosed()) {
            // throw new NoSuchElementException("Console not available");
            // }
            Map.Entry<Item, Integer> next = this.current;
            this.current = null;

            if (next == null) {
                // hasNext() wasn't called before
                next = this.getNextItem();
                if (next == null) {
                    throw new NoSuchElementException("No more Items available");
                }
            }

            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Map.Entry<Item, Integer> nextItem() {
        try {
        	 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	 String inputStr = in.readLine();
        	 if(inputStr.length()==0){
        		 return null ;
        	 }
        	 String quantity = inputStr.substring(0, 1);
             int qty = Integer.parseInt(quantity);
             String[] temp = (inputStr.substring(2, inputStr.length())).split(" at ");
             String name = temp[0];
             String price1 = temp[1];
             float price = Float.parseFloat(price1);
             boolean isImpoerted = false;
             if(name.contains("imported ")){
                 isImpoerted = true;
             }
             Category category = new ProductCategory(InputReader.getCategory(name).name());
             Item item = new Item(qty, name, category, isImpoerted, price);
             //Item item = new Item(qty, name, InputReader.getCategory(name), isImpoerted, price);
             return new java.util.AbstractMap.SimpleEntry<Item, Integer>(item, qty);
            
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean isClosed() {
        return false;
    }
}
