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

public class InvoLineDialougView extends JDialog{
    private JTextField itemNameFld;
    private JTextField itemCountFld;
    private JTextField itemPriceFld;
    private JLabel itemNameLab;
    private JLabel itemCountLab;
    private JLabel itemPriceLab;
    private JButton okBttn;
    private JButton cancelBttn;
    
    public InvoLineDialougView(InvoFrameView frame) {
        itemNameFld = new JTextField(20);
        itemNameLab = new JLabel("Item Name");
        itemNameLab.setBorder(new EmptyBorder(0,10,0,0));
        
        itemCountFld = new JTextField(20);
        itemCountLab = new JLabel("Item Count");
        itemCountLab.setBorder(new EmptyBorder(0,10,0,0));
        
        itemPriceFld = new JTextField(20);
        itemPriceLab = new JLabel("Item Price");
        itemPriceLab.setBorder(new EmptyBorder(0,10,0,0));
        
        okBttn = new JButton("OK");
        cancelBttn = new JButton("Cancel");
        
        okBttn.setActionCommand("newLineOK");
        cancelBttn.setActionCommand("newLineCancel");
        
        okBttn.addActionListener(frame.getListenToActions());
        cancelBttn.addActionListener(frame.getListenToActions());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLab);
        add(itemNameFld);
        add(itemCountLab);
        add(itemCountFld);
        add(itemPriceLab);
        add(itemPriceFld);
        add(okBttn);
        add(cancelBttn);
        
        pack(); 
    }

    public JTextField getItemNameFld() {
        return itemNameFld;
    }

    public JTextField getItemCountFld() {
        return itemCountFld;
    }

    public JTextField getItemPriceFld() {
        return itemPriceFld;
    }
}
