package com.sinvog.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ِAhmed
 */ 

public class InvoHeadDialougView extends JDialog {
    private JTextField cstNameFld;
    private JTextField invoDateFld;
    private JLabel cstNameLab;
    private JLabel invoDateLab;
    private JButton okBttn;
    private JButton cancelBttn;

    public InvoHeadDialougView(InvoFrameView frame) {
        cstNameLab = new JLabel("Customer Name:");
        cstNameLab.setBorder(new EmptyBorder(0,10,0,0));
        
        cstNameFld = new JTextField(20);
     
        invoDateLab = new JLabel("Invoice Date:");
        invoDateLab.setBorder(new EmptyBorder(0,10,0,0));
        
        invoDateFld = new JTextField(20);
        
        okBttn = new JButton("OK");
        cancelBttn = new JButton("Cancel");
        
        okBttn.setActionCommand("newInvoiceOK");
        cancelBttn.setActionCommand("newInvoiceCancel");
        
        
        okBttn.addActionListener(frame.getListenToActions());
        cancelBttn.addActionListener(frame.getListenToActions());
        setLayout(new GridLayout(3, 2));
        
        add(invoDateLab);
        add(invoDateFld);
        add(cstNameLab);
        add(cstNameFld);
        add(okBttn);
        add(cancelBttn);
        
        pack();
        
    }

    public JTextField getCstNameFld() {
        return cstNameFld;
    }

    public JTextField getInvoDateFld() {
        return invoDateFld;
    }
    
}
