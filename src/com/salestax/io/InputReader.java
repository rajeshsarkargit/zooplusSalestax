package com.salestax.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.salestax.core.Category;
import com.salestax.core.CategoryEnum;
import com.salestax.core.ProductCategory;
import com.salestax.model.Item;

public class InputReader {
	public static List<List<Item>> getOrders() {
        //List<Map.Entry<Item, Integer>> orders = new ArrayList<>();
        List<List<Item>> totalorders = new ArrayList<>();
        try {
            InputStreamReader ir = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ir);
            String inputStr = " ";
            List<Item> orders = null;
            System.out.println("Please Enter Your Orders: ");
            while (!inputStr.equals("Stop")) {
                boolean isnewListRequed = true;
                try {
                    inputStr = br.readLine();
                    if (inputStr.equalsIgnoreCase("Stop")) {
                    	if(null != orders){
                        	totalorders.add(orders);
                        }
                        break;
                    }
                    if (inputStr.length()==0) {
                    	continue;
                    }
                    if (inputStr.startsWith("Order ")) {
                        isnewListRequed = true;
                        if(null != orders){
                        	totalorders.add(orders);
                        }
                        orders = new ArrayList<>();
                    } else {
                        isnewListRequed = false;
                    }
                } catch (NumberFormatException e) {
                    isnewListRequed = false;
                }

                if (!isnewListRequed) {
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
                    Category category = new ProductCategory(getCategory(name).name());
                    Item item = new Item(qty, name, category, isImpoerted, price);
                  //Item item = new Item(qty, name, InputReader.getCategory(name), isImpoerted, price);
                    orders.add(item);
                }
            }
            br.close();
            ir.close();
            System.out.println();
            return totalorders;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public static CategoryEnum getCategory(String category){
        if(category.contains("book")){
            return CategoryEnum.BOOK;
        }else if(category.contains("food")){
            return CategoryEnum.FOOD;
        }else if(category.contains("chocolate")){
            return CategoryEnum.FOOD;
        }else if(category.contains("music")){
            return CategoryEnum.MUSIC;
        }else if(category.contains("pills")||category.contains("headache")){
            return CategoryEnum.MEDICINE;
        }else{
            return CategoryEnum.DEFAULT;
        }
    }
    
}
