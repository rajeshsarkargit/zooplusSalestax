package com.salestax.core;

import com.salestax.model.Item;

public class TaxCalFactory implements Tax<Item> {
	
	public static Tax getTaxCalculator(Item item){
		Tax calc = null;
		//String cat = item.getCategory().name();
		String cat = item.getCategory().getName();
        if (cat.equalsIgnoreCase("FOOD") || cat.equalsIgnoreCase("MEDICINE")
                        || cat.equalsIgnoreCase("BOOK"))
            calc = new BaseTax();
        else {
            calc = new SalesTax();
        }
        if (item.isImported)
            calc = new ImportTax(calc);
		return calc;
    }
	
	@Override
	public float compute(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

}
