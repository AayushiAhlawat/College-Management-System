
package Com.Dufins.Developer.Applications.Library;

import Util.Coloumnautosizer;
import Util.Util;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Account extends javax.swing.JPanel {

    /**
     * Creates new form Account
     */
    Connection connection = null;
    ResultSet rsdue = null;
    PreparedStatement stmt = null;
    String value = "";

    public Account() {
        initComponents();
        try {
            connection = Util.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear();
    }

    public void clear() {
        cmbMember.setSelectedIndex(0);
        TxtMember.setText("");
        txtTotalFine.setText("");
        TxtEnterFine.setText("");
        TxtEnterFine.setEnabled(false);
        CmdPay.setEnabled(false);

        jTable1.getColumnModel().getColumn(0).setHeaderValue("BOOK ID");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("FINE");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("FINE PAID DATE");
        jTable1.getColumnModel().getColumn(3).setHeaderValue("PAID AMOUNT");
        jTable1.getColumnModel().getColumn(4).setHeaderValue("TOTAL RETURN DAYS");

        jTable1.getTableHeader().resizeAndRepaint();

        while (jTable1.getRowCount() > 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        MemberData = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMemberData = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTotalFine = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TxtEnterFine = new javax.swing.JTextField();
        TxtMember = new javax.swing.JTextField();
        cmbMember = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        CmdSearch = new javax.swing.JLabel();
        CmdPay = new javax.swing.JLabel();
        Export2Excel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        MemberData.getContentPane().setLayout(new javax.swing.BoxLayout(MemberData.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jTableMemberData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMemberData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMemberDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMemberData);

        MemberData.getContentPane().add(jScrollPane1);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Search By:");

        txtTotalFine.setEditable(false);
        txtTotalFine.setText("jTextField2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Enter Fine:");

        TxtEnterFine.setText("jTextField3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtEnterFine, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtEnterFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TxtMember.setText("jTextField1");

        cmbMember.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Member ID", "Member Name" }));

        jLabel2.setText("Total Fine:");

        CmdSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search-icon.png"))); // NOI18N
        CmdSearch.setToolTipText("Search");
        CmdSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmdSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CmdSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmdSearchMouseClicked(evt);
            }
        });

        CmdPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_as.png"))); // NOI18N
        CmdPay.setToolTipText("Click to pay fine");
        CmdPay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmdPay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CmdPay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmdPayMouseClicked(evt);
            }
        });

        Export2Excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/table_excel.png"))); // NOI18N
        Export2Excel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Export2Excel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Export2Excel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Export2ExcelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtMember, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CmdSearch))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalFine, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CmdPay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Export2Excel)
                        .addGap(0, 77, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmdSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTotalFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmdPay)
                    .addComponent(Export2Excel))
                .addGap(14, 14, 14))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nilaicon.png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(jTable1);
        jScrollPane2.getViewport().setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CmdSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmdSearchMouseClicked
        // TODO add your handling code here:

        try {
            if (TxtMember.getText().length() <= 0) {
                clear();
                return;
            }

            if (cmbMember.getSelectedIndex() == 0) {
                value = TxtMember.getText();
            } else if (cmbMember.getSelectedIndex() == 1) {
                stmt = connection.prepareStatement("SELECT mem_id as ' MEMBER ID', mem_name as 'MEMBER NAME' FROM membermaster where mem_name like '" + TxtMember.getText() + "%' order by mem_id");
                rsdue = stmt.executeQuery();
                jTableMemberData.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rsdue));
                Coloumnautosizer.sizeColumnsToFit(jTableMemberData);
                MemberData.setVisible(true);
                MemberData.setBounds(100, 100, 150, 500);
            }
            stmt = connection.prepareStatement("Select trn_book_id as 'BOOK ID', fine as 'FINE', fine_paid_dt as 'FINE PAID DATE', paid_amount as 'PAID AMOUNT', book_rtn_days as 'TOTAL RETURN DAYS' from lib_account where trn_mem_id = " + value + "");
            rsdue = stmt.executeQuery();
            jTable1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rsdue));

            stmt = connection.prepareStatement("Select due from lib_account where trn_mem_id = " + value + "");
            rsdue = stmt.executeQuery();
            if (rsdue.last()) {
                txtTotalFine.setText(rsdue.getString(1));
                TxtEnterFine.setEnabled(true);
                CmdPay.setEnabled(true);
            } else {
                txtTotalFine.setText("0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CmdSearchMouseClicked

    public void updateDue() {
        try {
            PreparedStatement psmnt = connection.prepareStatement("select sum(fine), sum(paid_amount) from lib_account where trn_mem_id = ?");
            psmnt.setInt(1, Integer.parseInt(value));
            ResultSet rsfine = psmnt.executeQuery();
            if (rsfine.next()) {
                int totalDue = rsfine.getInt(1) - rsfine.getInt(2);
                psmnt = connection.prepareStatement("Update lib_account set due = ? where trn_mem_id = ?");
                psmnt.setInt(1, totalDue);
                psmnt.setInt(2, Integer.parseInt(value));
                int s = psmnt.executeUpdate();
                if (s > 0) {
                    System.out.println("lib due updated");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jTableMemberDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMemberDataMouseClicked
        // TODO add your handling code here:
        int row = jTableMemberData.getSelectedRow();
        try {
            value = jTableMemberData.getValueAt(row, 0).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jTableMemberDataMouseClicked

    private void CmdPayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmdPayMouseClicked
        // TODO add your handling code here:
        int paid = 0;
        System.out.println("value " + value);
        if (value.equals("")) {

            return;
        }
        try {

            stmt = connection.prepareStatement("select * from lib_account where trn_mem_id = " + value + "");
            ResultSet rspaid = stmt.executeQuery();
            if (rspaid.last()) {
                stmt = connection.prepareStatement("update lib_account set paid_amount = ?, fine_paid_dt = ?  where lib_acc_id = ?");
                paid = rspaid.getInt(6) + Integer.parseInt(TxtEnterFine.getText());
                stmt.setInt(1, paid);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                stmt.setString(2, df.format(new Date()));
                stmt.setString(3, rspaid.getString(1));
                int p = stmt.executeUpdate();
                if (p > 0) {
                    JOptionPane.showMessageDialog(this, "Payment of RS " + TxtEnterFine.getText() + " successful. ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateDue();
        clear();
    }//GEN-LAST:event_CmdPayMouseClicked

    private void Export2ExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Export2ExcelMouseClicked
        // TODO add your handling code here:
        if (value.equals("")) {
            JOptionPane.showMessageDialog(this, "Please check correct member id.");
            return;
        }

        try {
            String filename = "";

            JFileChooser fc = new JFileChooser();

            int returnVal = fc.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                filename = (file.toString()+".xls").replace('\\', '/');
            }
            System.out.println("file name "+filename);
            stmt = connection.prepareStatement("select 'BOOK ID', 'FINE', 'FINE PAID DATE', 'PAID AMOUNT', 'TOTAL RETURN DAYS' union select trn_book_id, fine, fine_paid_dt, paid_amount, book_rtn_days INTO OUTFILE '" + filename + "' LINES TERMINATED BY '\n' from lib_account where trn_mem_id = " + value + "");
            rsdue = stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_Export2ExcelMouseClicked

   
    private javax.swing.JLabel CmdPay;
    private javax.swing.JLabel CmdSearch;
    private javax.swing.JLabel Export2Excel;
    private javax.swing.JFrame MemberData;
    private javax.swing.JTextField TxtEnterFine;
    private javax.swing.JTextField TxtMember;
    private javax.swing.JComboBox cmbMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableMemberData;
    private javax.swing.JTextField txtTotalFine;
   
}
