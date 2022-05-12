package com.sinvog.model;

/**
 *
 * @author ِAhmed
 */

public class InvoLineModel {
    private String allitems;
    private double price;
    private int count;
    private InvoHeadModel headers;

    public InvoLineModel() {
    }

    public InvoLineModel(String item, double price, int count, InvoHeadModel header) {
        this.allitems = item;
        this.price = price;
        this.count = count;
        this.headers = header;
    }

    public InvoHeadModel getHeaders() {
        return headers;
    }

    public void setHeaders(InvoHeadModel headers) {
        this.headers = headers;
    }

    public String getAllitems() {
        return allitems;
    }

    public void setAllitems(String allitems) {
        this.allitems = allitems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public double getLineTotal() {
        return price * count;
    }

    @Override
    public String toString() {
        return headers.getNumb() + "," + allitems + "," + price + "," + count;
    }

    
    
}
