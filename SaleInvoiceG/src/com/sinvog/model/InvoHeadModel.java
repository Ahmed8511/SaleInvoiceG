package com.sinvog.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ِAhmed
 */

public class InvoHeadModel {
    private int numb;
    private String cst;
    private Date invoDate;
    private ArrayList<InvoLineModel> alllines;
    private DateFormat dteFormat = new SimpleDateFormat("dd-MM-yyyy");

    public InvoHeadModel() {
    }

    public InvoHeadModel(int numb, String cst, Date invoDate) {
        this.numb = numb;
        this.cst = cst;
        this.invoDate = invoDate;
    }

    public Date getInvoDate() {
        return invoDate;
    }

    public void setInvoDate(Date invoDate) {
        this.invoDate = invoDate;
    }

    public int getNumb() {
        return numb;
    }

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }

    public ArrayList<InvoLineModel> getAlllines() {
        if (alllines == null) {
            alllines = new ArrayList<>();
        }
        return alllines;
    }

    public void setAlllines(ArrayList<InvoLineModel> alllines) {
        this.alllines = alllines;
    }
    
    public double getInvoiceTotal() {
        double total = 0.0;
        
        for (int i = 0; i < getAlllines().size(); i++) {
            total += getAlllines().get(i).getLineTotal();
        }
        
        return total;
    }

    @Override
    public String toString() {
        return numb + "," + dteFormat.format(invoDate) + "," + cst;
    }
    
}
