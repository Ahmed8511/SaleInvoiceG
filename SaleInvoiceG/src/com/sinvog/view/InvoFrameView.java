package com.sinvog.view;

import com.sinvog.controller.InvoActListener;
import com.sinvog.controller.TableSelectListener;
import com.sinvog.model.InvoHeadModel;
import com.sinvog.model.InvoHeadTableModel;
import com.sinvog.model.InvoLineModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author ِAhmed
 */

public class InvoFrameView extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    public InvoFrameView() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new javax.swing.JScrollPane();
        invoHeadTbl = new javax.swing.JTable();
        createInvoBttn = new javax.swing.JButton();
        deleteInvoBttn = new javax.swing.JButton();
        InvoNumLab = new javax.swing.JLabel();
        InvoDateLab = new javax.swing.JLabel();
        CstNameLab = new javax.swing.JLabel();
        InvoTotalLab = new javax.swing.JLabel();
        cstNameLab = new javax.swing.JLabel();
        invoDateLab = new javax.swing.JLabel();
        invoNumLab = new javax.swing.JLabel();
        invoTotalLab = new javax.swing.JLabel();
        scrollPane2 = new javax.swing.JScrollPane();
        invoLineTbl = new javax.swing.JTable();
        createLineBttn = new javax.swing.JButton();
        deleteLineBttn = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        menu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoHeadTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        invoHeadTbl.getSelectionModel().addListSelectionListener(selectionListener);
        scrollPane1.setViewportView(invoHeadTbl);

        createInvoBttn.setText("New Invoice");
        createInvoBttn.addActionListener(listenToActions);

        deleteInvoBttn.setText("Delete Invoice");
        deleteInvoBttn.addActionListener(listenToActions);

        InvoNumLab.setText("Invoice Number:");

        InvoDateLab.setText("Invoice Date:");

        CstNameLab.setText("Customer Name:");

        InvoTotalLab.setText("Invoice Total:");

        invoLineTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrollPane2.setViewportView(invoLineTbl);

        createLineBttn.setText("New Line");
        createLineBttn.addActionListener(listenToActions);

        deleteLineBttn.setText("Delete Line");
        deleteLineBttn.addActionListener(listenToActions);

        menu1.setText("File");

        loadMenuItem.setText("Load Files");
        loadMenuItem.addActionListener(listenToActions);
        menu1.add(loadMenuItem);

        saveMenuItem.setText("Save Files");
        saveMenuItem.addActionListener(listenToActions);
        menu1.add(saveMenuItem);

        jMenuBar.add(menu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CstNameLab)
                            .addComponent(InvoDateLab)
                            .addComponent(InvoNumLab)
                            .addComponent(InvoTotalLab))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoTotalLab)
                            .addComponent(invoNumLab)
                            .addComponent(invoDateLab)
                            .addComponent(cstNameLab)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(createInvoBttn)
                .addGap(85, 85, 85)
                .addComponent(deleteInvoBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createLineBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(deleteLineBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoNumLab)
                            .addComponent(invoNumLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoDateLab)
                            .addComponent(invoDateLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CstNameLab)
                            .addComponent(cstNameLab))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoTotalLab)
                            .addComponent(invoTotalLab))
                        .addGap(26, 26, 26)
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteInvoBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createInvoBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createLineBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteLineBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoFrameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoFrameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CstNameLab;
    private javax.swing.JLabel InvoDateLab;
    private javax.swing.JLabel InvoNumLab;
    private javax.swing.JLabel InvoTotalLab;
    private javax.swing.JButton createInvoBttn;
    private javax.swing.JButton createLineBttn;
    private javax.swing.JLabel cstNameLab;
    private javax.swing.JButton deleteInvoBttn;
    private javax.swing.JButton deleteLineBttn;
    private javax.swing.JLabel invoDateLab;
    private javax.swing.JTable invoHeadTbl;
    private javax.swing.JTable invoLineTbl;
    private javax.swing.JLabel invoNumLab;
    private javax.swing.JLabel invoTotalLab;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables
    private InvoActListener listenToActions = new InvoActListener(this);
    private ArrayList<InvoHeadModel> allinvoArrays;
    private ArrayList<InvoLineModel> alllinesArrays;
    private InvoHeadTableModel headTablMod;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private TableSelectListener selectionListener = new TableSelectListener(this);

    public ArrayList<InvoLineModel> getAlllinesArrays() {
        return alllinesArrays;
    }

    public void setAlllinesArrays(ArrayList<InvoLineModel> alllinesArrays) {
        this.alllinesArrays = alllinesArrays;
    }
    
    public void setAllinvoArrays(ArrayList<InvoHeadModel> allinvoArrays) {
        this.allinvoArrays = allinvoArrays;
    }

    public ArrayList<InvoHeadModel> getAllinvoArrays() {
        return allinvoArrays;
    }
    
    public InvoHeadModel getInvObject(int code) {
        for (InvoHeadModel invo : allinvoArrays) {
            if (invo.getNumb() == code) {
                return invo;
            }
        }
        return null;
    }

    public InvoHeadTableModel getHeadTablMod() {
        return headTablMod;
    }

    public void setHeadTablMod(InvoHeadTableModel headTablMod) {
        this.headTablMod = headTablMod;
    }

    public JTable getInvoHeadTbl() {
        return invoHeadTbl;
    }

    public JTable getInvoLineTbl() {
        return invoLineTbl;
    }

    public JLabel getCstNameLab() {
        return cstNameLab;
    }

    public JLabel getInvoDateLab() {
        return invoDateLab;
    }

    public JLabel getInvoNumLab() {
        return invoNumLab;
    }

    public JLabel getInvoTotalLab() {
        return invoTotalLab;
    }

    public InvoActListener getListenToActions() {
        return listenToActions;
    }
    
    
}
