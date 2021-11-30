package com.salestax.processor;

import java.util.ArrayList;
import java.util.List;
import com.salestax.core.BaseTax;
import com.salestax.core.ImportTax;
import com.salestax.core.SalesTax;
import com.salestax.core.Tax;
import com.salestax.core.TaxCalFactory;
import com.salestax.core.ValueRounder;
import com.salestax.model.Item;

public class OrderProcessor implements IOrder {
	// private int qunatity;

    private float totalAmount;

    private float totalSalesTax;


    private List<Item> items = new ArrayList<>();


    @Override
    public void process() {
        for (Item item : items) {
            Tax calc = new BaseTax();
            calc=TaxCalFactory.getTaxCalculator(item);
            calc = new ValueRounder(calc);
            float salesTax = calc.compute(item);
            item.setTotalPrice((item.getBasePrice() + salesTax) * item.getQuantity());
            totalAmount += (item.getBasePrice() + salesTax) * item.getQuantity();
            totalSalesTax += salesTax;
        }
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getTotalSalesTax() {
        return totalSalesTax;
    }

    public void setTotalSalesTax(float totalSalesTax) {
        this.totalSalesTax = totalSalesTax;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // public int getQunatity() {
    // return qunatity;
    // }
    //
    // public void setQunatity(int qunatity) {
    // this.qunatity = qunatity;
    // }

}
