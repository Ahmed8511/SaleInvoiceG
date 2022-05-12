package com.sinvog.controller;

import com.sinvog.model.InvoHeadModel;
import com.sinvog.model.InvoLineModel;
import com.sinvog.model.InvoLineTblModel;
import com.sinvog.view.InvoFrameView;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ِAhmed
 */

public class TableSelectListener implements ListSelectionListener {

    private InvoFrameView myFrame;

    public TableSelectListener(InvoFrameView myframe) {
        this.myFrame = myframe;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int choosenInvoIndx = myFrame.getInvoHeadTbl().getSelectedRow();
        System.out.println("Invoice selected: " + choosenInvoIndx);
        if (choosenInvoIndx != -1) {
            InvoHeadModel selectedInv = myFrame.getAllinvoArrays().get(choosenInvoIndx);
            ArrayList<InvoLineModel> lines = selectedInv.getAlllines();
            InvoLineTblModel lineTablMod = new InvoLineTblModel(lines);
            myFrame.setAlllinesArrays(lines);
            myFrame.getInvoLineTbl().setModel(lineTablMod);
            myFrame.getCstNameLab().setText(selectedInv.getCst());
            myFrame.getInvoNumLab().setText("" + selectedInv.getNumb());
            myFrame.getInvoTotalLab().setText("" + selectedInv.getInvoiceTotal());
            myFrame.getInvoDateLab().setText(InvoFrameView.dateFormat.format(selectedInv.getInvoDate()));
            System.out.println(lines);
        }
    }

    
}
