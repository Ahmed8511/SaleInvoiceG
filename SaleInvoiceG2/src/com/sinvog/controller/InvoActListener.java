package com.sinvog.controller;

import com.sinvog.model.InvoHeadModel;
import com.sinvog.model.InvoHeadTableModel;
import com.sinvog.model.InvoLineModel;
import com.sinvog.model.InvoLineTblModel;
import com.sinvog.view.InvoFrameView;
import com.sinvog.view.InvoHeadDialougView;
import com.sinvog.view.InvoLineDialougView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */

public class InvoActListener implements ActionListener {

    private InvoFrameView myFrame;
    private InvoLineDialougView lineupDialoug;
    private InvoHeadDialougView headsDialoug;
    

    public InvoActListener(InvoFrameView myframe) {
        this.myFrame = myframe;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            
            case "Load Files":
                loadFiles();
                break;
            case "Save Files":
                saveFiles();
                break;  
                
            case "Delete Invoice":
                deleteInvoice();
                break;
                
            case "New Invoice":
                createNewInvoice();
                break;

            case "New Line":
                createNewLine();
                break;

            case "Delete Line":
                deleteLine();
                break;
            case "newLineCancel":
                newLineDialogCancel();
                break;

            case "newLineOK":
                newLineDialogOK();
                break;    

            case "newInvoiceOK":
                newInvoiceDialogOK();
                break;

            case "newInvoiceCancel":
                newInvoiceDialogCancel();
                break;

        }
    }

    private void loadFiles() {
        JFileChooser fileSelector = new JFileChooser();
        try {
            int result = fileSelector.showOpenDialog(myFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileSelector.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                ArrayList<InvoHeadModel> invoiHeaders = new ArrayList<>();
                for (String headerLine : headerLines) {
                    String[] myarry = headerLine.split(",");
                    String strn1 = myarry[0];
                    String strn2 = myarry[1];
                    String strn3 = myarry[2];
                    
                    int code = Integer.parseInt(strn1);
                    Date invoiceDate = InvoFrameView.dateFormat.parse(strn2);
                    InvoHeadModel header = new InvoHeadModel(code, strn3, invoiceDate);
                    invoiHeaders.add(header);
                }
                myFrame.setAllinvoArrays(invoiHeaders);
                System.out.println(invoiHeaders);

                result = fileSelector.showOpenDialog(myFrame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fileSelector.getSelectedFile();
                    Path linerPath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineMyLines = Files.readAllLines(linerPath);
                    for (String lineLine : lineMyLines) {
                        String[] myarry = lineLine.split(",");
                        
                        String strn1 = myarry[0];
                        String strn2 = myarry[1];
                        String strn3 = myarry[2];
                        String strn4 = myarry[3];
                            
                        int invoCode = Integer.parseInt(strn1);
                        double price = Double.parseDouble(strn3);
                        int count = Integer.parseInt(strn4);
                        InvoHeadModel inv = myFrame.getInvObject(invoCode);
                        InvoLineModel line = new InvoLineModel(strn2, price, count, inv);
                        inv.getAlllines().add(line);
                    }
                }
                InvoHeadTableModel headerTablMod = new InvoHeadTableModel(invoiHeaders);
                myFrame.setHeadTablMod(headerTablMod);
                myFrame.getInvoHeadTbl().setModel(headerTablMod);
                System.out.println("read files");
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(myFrame, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(myFrame, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createNewInvoice() {
        headsDialoug = new InvoHeadDialougView(myFrame);
        headsDialoug.setVisible(true);
    }

    private void deleteInvoice() {
        int selectedInvoiceIndex = myFrame.getInvoHeadTbl().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            myFrame.getAllinvoArrays().remove(selectedInvoiceIndex);
            myFrame.getHeadTablMod().fireTableDataChanged();

            myFrame.getInvoLineTbl().setModel(new InvoLineTblModel(null));
            myFrame.setAlllinesArrays(null);
            myFrame.getCstNameLab().setText("");
            myFrame.getInvoNumLab().setText("");
            myFrame.getInvoTotalLab().setText("");
            myFrame.getInvoDateLab().setText("");
        }
    }

    private void createNewLine() {
        lineupDialoug = new InvoLineDialougView(myFrame);
        lineupDialoug.setVisible(true);
    }

    private void deleteLine() {
        int selectedLineIndex = myFrame.getInvoLineTbl().getSelectedRow();
        int selectedInvoiceIndex = myFrame.getInvoHeadTbl().getSelectedRow();
        if (selectedLineIndex != -1) {
            myFrame.getAlllinesArrays().remove(selectedLineIndex);
            InvoLineTblModel lineTableModel = (InvoLineTblModel) myFrame.getInvoLineTbl().getModel();
            lineTableModel.fireTableDataChanged();
            myFrame.getInvoTotalLab().setText("" + myFrame.getAllinvoArrays().get(selectedInvoiceIndex).getInvoiceTotal());
            myFrame.getHeadTablMod().fireTableDataChanged();
            myFrame.getInvoHeadTbl().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

     private void saveFiles() {
        ArrayList<InvoHeadModel> invoicesArray = myFrame.getAllinvoArrays();
        JFileChooser fselect = new JFileChooser();
        try {
            int result = fselect.showSaveDialog(myFrame);
            
            if (result == JFileChooser.APPROVE_OPTION) {
                
                String myheaders = "";
                for (InvoHeadModel invoice : invoicesArray) {
                    myheaders += invoice.toString();
                    myheaders += "\n";
                }
                myheaders = myheaders.substring(0, myheaders.length()-1);
                File headerFile = fselect.getSelectedFile();
                FileWriter hfilew = new FileWriter(headerFile);
                hfilew.write(myheaders);
                hfilew.close();
            }
            result = fselect.showSaveDialog(myFrame);
            if (result == JFileChooser.APPROVE_OPTION) {
                String myheaders = "";
                String csvlines = "";
                for (InvoHeadModel invoice : invoicesArray) {
                    myheaders += invoice.toString();
                    myheaders += "\n";
                    for (InvoLineModel line : invoice.getAlllines()) {
                        csvlines += line.toString();
                        csvlines += "\n";
                    }
                }
                csvlines = csvlines.substring(0, csvlines.length()-1);            
                File mylineFile = fselect.getSelectedFile();
                FileWriter linefilew = new FileWriter(mylineFile);
                linefilew.write(csvlines);
                linefilew.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(myFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newInvoiceDialogCancel() {
        headsDialoug.setVisible(false);
        headsDialoug.dispose();
        headsDialoug = null;
    }

    private void newInvoiceDialogOK() {
        headsDialoug.setVisible(false);

        String cstName = headsDialoug.getCstNameFld().getText();
        String str = headsDialoug.getInvoDateFld().getText();
        Date dte = new Date();
        try {
            dte = InvoFrameView.dateFormat.parse(str);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(myFrame, "Can't resolve date, resetting to today", "Wrong date format", JOptionPane.ERROR_MESSAGE);
        }

        int invoNum = 0;
        for (InvoHeadModel inv : myFrame.getAllinvoArrays()) {
            if (inv.getNumb() > invoNum) {
                invoNum = inv.getNumb();
            }
        }
        invoNum++;
        InvoHeadModel newInv = new InvoHeadModel(invoNum, cstName, dte);
        myFrame.getAllinvoArrays().add(newInv);
        myFrame.getHeadTablMod().fireTableDataChanged();
        headsDialoug.dispose();
        headsDialoug = null;
    }

    private void newLineDialogCancel() {
        lineupDialoug.setVisible(false);
        lineupDialoug.dispose();
        lineupDialoug = null;
    }
    private void newLineDialogOK() {
        lineupDialoug.setVisible(false);

        String name = lineupDialoug.getItemNameFld().getText();
        String strn1 = lineupDialoug.getItemCountFld().getText();
        String strn2 = lineupDialoug.getItemPriceFld().getText();
        int count = 1;
        double price = 1;
        try {
            count = Integer.parseInt(strn1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(myFrame, "Can't convert number.", "Wrong number format", JOptionPane.ERROR_MESSAGE);
        }

        try {
            price = Double.parseDouble(strn2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(myFrame, "Can't convert price", "Wrong number format", JOptionPane.ERROR_MESSAGE);
        }
        int selectedInvoHead = myFrame.getInvoHeadTbl().getSelectedRow();
        if (selectedInvoHead != -1) {
            InvoHeadModel invoHeader = myFrame.getAllinvoArrays().get(selectedInvoHead);
            InvoLineModel line = new InvoLineModel(name, price, count, invoHeader);
            myFrame.getAlllinesArrays().add(line);
            InvoLineTblModel invoLineTableModel = (InvoLineTblModel) myFrame.getInvoLineTbl().getModel();
            invoLineTableModel.fireTableDataChanged();
            myFrame.getHeadTablMod().fireTableDataChanged();
        }
        myFrame.getInvoHeadTbl().setRowSelectionInterval(selectedInvoHead, selectedInvoHead);
        lineupDialoug.dispose();
        lineupDialoug = null;
        
        
    }

}
