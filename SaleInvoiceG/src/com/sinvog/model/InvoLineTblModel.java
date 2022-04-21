package com.sinvog.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ِAhmed
 */

public class InvoLineTblModel extends AbstractTableModel {

    private ArrayList<InvoLineModel> alllineArrays;
    private String[] allcolumns = {"Item Name", "Unit Price", "Count", "Line Total"};

    public InvoLineTblModel(ArrayList<InvoLineModel> lineArrays) {
        this.alllineArrays = lineArrays;
    }

    @Override
    public int getRowCount() {
        return alllineArrays == null ? 0 : alllineArrays.size();
    }

    @Override
    public int getColumnCount() {
        return allcolumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (alllineArrays == null) {
            return "";
        } else {
            InvoLineModel line = alllineArrays.get(rowIndex);
            switch (columnIndex) {
                
                default:
                    return "";
                case 1:
                    return line.getPrice();
                case 2:
                    return line.getCount();
                case 3:
                    return line.getLineTotal();
                case 0:
                    return line.getAllitems();    
                
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return allcolumns[column];
    }

    
}
