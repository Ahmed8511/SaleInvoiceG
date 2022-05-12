package com.sinvog.model;

import com.sinvog.view.InvoFrameView;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/** 
 *
 * @author ِAhmed
 */

public class InvoHeadTableModel extends AbstractTableModel {

    private ArrayList<InvoHeadModel> invoArrayS;
    private String[] allColumns = {"Invoice No.", "Invoice Date", "Customer Name", "Invoice Total"};
    
    public InvoHeadTableModel(ArrayList<InvoHeadModel> invoArrayS) {
        this.invoArrayS = invoArrayS;
    }

    @Override
    public int getRowCount() {
        return invoArrayS.size();
    }

    @Override
    public int getColumnCount() {
        return allColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoHeadModel invo = invoArrayS.get(rowIndex);
        switch (columnIndex) {
            case 1: return InvoFrameView.dateFormat.format(invo.getInvoDate());
            case 2: return invo.getCst();
            case 3: return invo.getInvoiceTotal();
            case 0: return invo.getNumb();
        }
        return "";
    }

    @Override
    public String getColumnName(int scolumn) {
        return allColumns[scolumn];
    }
}
