
package Com.Dufins.Developer.Applications.Library;

import Util.Util;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReturnBook extends javax.swing.JPanel {

    /**
     * Creates new form ReturnBook
     */
    ArrayList list = new ArrayList();
    int row = 0;
    Connection connection = null;
    int totalFine = 0;

    public ReturnBook() {
        initComponents();
        ClearText();
        while (jTable1.getRowCount() > 0) {
            ((DefaultTableModel) jTable1.getModel()).removeRow(0);
        }

        jTable1.getColumnModel().getColumn(0).setHeaderValue("Book ID");
        jTable1.getColumnModel().getColumn(1).setHeaderValue("Issue Date");
        jTable1.getColumnModel().getColumn(2).setHeaderValue("Check Receiving");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TxtMemberID = new javax.swing.JTextField();
        TxtMemberName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtBookDetails = new javax.swing.JTextField();
        LblBookID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        CmdMemberDetails = new javax.swing.JLabel();
        CmdClear = new javax.swing.JLabel();
        CmdReceiveBook = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TxtMemberID.setText("jTextField1");
        TxtMemberID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtMemberIDFocusLost(evt);
            }
        });
        TxtMemberID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtMemberIDKeyReleased(evt);
            }
        });

        TxtMemberName.setEditable(false);
        TxtMemberName.setText("jTextField1");

        jLabel4.setText("Book :");

        jLabel3.setText("Member ID :");

        jLabel2.setText("Name :");

        TxtBookDetails.setEditable(false);
        TxtBookDetails.setText("jTextField1");

        LblBookID.setText("jLabel1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.getViewport().setBackground(Color.WHITE);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nilaicon.png"))); // NOI18N

        CmdMemberDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search-icon.png"))); // NOI18N
        CmdMemberDetails.setToolTipText("Search Detail");
        CmdMemberDetails.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmdMemberDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CmdMemberDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmdMemberDetailsMouseClicked(evt);
            }
        });

        CmdClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/edit-clear-3.png"))); // NOI18N
        CmdClear.setToolTipText("Clear");
        CmdClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmdClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CmdClear.setPreferredSize(new java.awt.Dimension(36, 36));
        CmdClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmdClearMouseClicked(evt);
            }
        });

        CmdReceiveBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_as.png"))); // NOI18N
        CmdReceiveBook.setToolTipText("Receive Book");
        CmdReceiveBook.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CmdReceiveBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CmdReceiveBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CmdReceiveBookMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(CmdReceiveBook)
                        .addGap(18, 18, 18)
                        .addComponent(CmdClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TxtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CmdMemberDetails))
                    .addComponent(TxtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBookDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblBookID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel3))
                            .addComponent(TxtMemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CmdMemberDetails))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtMemberName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtBookDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblBookID)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CmdClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmdReceiveBook)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ClearText() {
        TxtMemberID.setText("");
        TxtMemberName.setText("");
        TxtBookDetails.setText("");
        LblBookID.setText("");

        CmdReceiveBook.setEnabled(false);

    }

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here
        String sql = "";


        int row = jTable1.getSelectedRow();
        int col = jTable1.getSelectedColumn();
        if (row >= 0 || col >= 0) {
            try {
                // TODO add your handling code here:

                //checkFine();

                PreparedStatement psmnt = connection.prepareStatement("update transaction_cart set Chk_Rcv=? where trn_book_id =?");
                psmnt.setBoolean(1, (boolean) jTable1.getValueAt(row, 2));
                psmnt.setString(2, jTable1.getValueAt(row, 0).toString());
                int a = psmnt.executeUpdate();
                if (a > 0) {
                    System.out.println("tc's Chk RCV Updated.");
                }

                psmnt = connection.prepareStatement("update transaction set Chk_Rcv=? where trn_book_id =? and trn_issue_dt =?");
                psmnt.setBoolean(1, (boolean) jTable1.getValueAt(row, 2));
                psmnt.setString(2, jTable1.getValueAt(row, 0).toString());
                psmnt.setString(3, jTable1.getValueAt(row, 1).toString());
                a = psmnt.executeUpdate();
                if (a > 0) {
                    System.out.println("t's Chk RCV Updated.");
                }
                if (jTable1.getValueAt(row, 2).toString().equalsIgnoreCase("true")) {
                    sql = "update  bookmaster set status='Receiving' where book_id=" + jTable1.getValueAt(row, 0).toString();
                } else {
                    sql = "update  bookmaster set status='Issued' where book_id=" + jTable1.getValueAt(row, 0).toString();
                }
                psmnt = connection.prepareStatement(sql);
                psmnt.executeUpdate(sql);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable1PropertyChange

    private void TxtMemberIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtMemberIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtMemberIDFocusLost

    private void TxtMemberIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtMemberIDKeyReleased
        // TODO add your handling code here:
        if (TxtMemberID.getText().length() == 0) {
            while (jTable1.getRowCount() > 0) {
                ((DefaultTableModel) jTable1.getModel()).removeRow(0);
            }
            TxtBookDetails.setText("");
            TxtMemberName.setText("");
        }
    }//GEN-LAST:event_TxtMemberIDKeyReleased

    private void CmdMemberDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmdMemberDetailsMouseClicked
        //get member deatils
        try {
            //get database connection details


            int counter = 0;

            connection = Util.getConnection();
            String str = "";
            str = "select * from membermaster where mem_id =? ";
            PreparedStatement pst = connection.prepareStatement(str);
            pst.setString(1, TxtMemberID.getText());

            ResultSet rs;
            rs = pst.executeQuery();
            if (rs.next()) {
                TxtMemberName.setText(rs.getString("mem_name"));

                //get mem status
                str = "select trn_book_id, trn_issue_dt, Chk_Rcv from transaction where trn_mem_id =? and (trn_receive_dt is null  or trn_receive_dt='')";
                PreparedStatement pst1 = connection.prepareStatement(str);
                pst1.setString(1, TxtMemberID.getText());

                ResultSet rs1;
                rs1 = pst1.executeQuery();

                jTable1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs1));

                jTable1.getColumnModel().getColumn(2).setCellEditor(jTable1.getDefaultEditor(Boolean.class));
                jTable1.getColumnModel().getColumn(2).setCellRenderer(jTable1.getDefaultRenderer(Boolean.class));

                jTable1.getColumnModel().getColumn(0).setHeaderValue("Book ID");
                jTable1.getColumnModel().getColumn(1).setHeaderValue("Issue Date");
                jTable1.getColumnModel().getColumn(2).setHeaderValue("Check Receiving");

                rs1 = pst1.executeQuery();
                while (rs1.next()) {
                    counter++;
                }

                System.out.println("counter " + counter);
                if (counter > 0) {
                    TxtBookDetails.setText(counter + " Book available.");
                    CmdReceiveBook.setEnabled(true);

                } else {
                    TxtBookDetails.setText("No book available.");
                    CmdReceiveBook.setEnabled(false);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid member id.");
                TxtMemberID.setText("");
                TxtMemberName.setText("");
                TxtBookDetails.setText("");
                CmdReceiveBook.setEnabled(false);
                LblBookID.setText("");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        row = jTable1.getRowCount();
    }//GEN-LAST:event_CmdMemberDetailsMouseClicked

    private void CmdClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmdClearMouseClicked
        // TODO add your handling code here:
        ClearText();
    }//GEN-LAST:event_CmdClearMouseClicked

    private void CmdReceiveBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CmdReceiveBookMouseClicked
        // TODO add your handling code here:
        //issue book
        try {

            if (TxtMemberID.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Enter member id.");
                return;
            }

            connection = Util.getConnection();
            String sql = "select trn_issue_dt from transaction where Chk_Rcv > 0 and trn_mem_id=" + TxtMemberID.getText() + "";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                if(rs.getDate(1).after(new Date()))
                {
                    JOptionPane.showMessageDialog(this, "Incorrect System Date.");
                    return;
                }
            }
            
            sql = "update  transaction set trn_receive_dt = sysdate() where Chk_Rcv > 0 and trn_mem_id=" + TxtMemberID.getText() + "";
            pst = connection.prepareStatement(sql);
            pst.executeUpdate(sql);

            sql = "update  transaction_cart set trn_receive_dt = sysdate() where Chk_Rcv > 0 and trn_mem_id=" + TxtMemberID.getText() + "";
            pst = connection.prepareStatement(sql);
            pst.executeUpdate(sql);

            checkFine();

            sql = "delete from transaction_cart where Chk_Rcv > 0 and trn_mem_id=" + TxtMemberID.getText() + "";
            pst = connection.prepareStatement(sql);
            pst.executeUpdate();

            sql = "update  bookmaster set status='Available' where status='Receiving' and mem_id=" + TxtMemberID.getText() + "";
            pst = connection.prepareStatement(sql);
            pst.executeUpdate(sql);

            if (jTable1.getRowCount() > 0) {
                CmdMemberDetailsMouseClicked(null);
            } else {
                TxtMemberID.setText("");
                TxtMemberName.setText("");
                TxtBookDetails.setText("");
            }

            JOptionPane.showMessageDialog(null, "Book Received");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_CmdReceiveBookMouseClicked

    public void checkFine() {
        int fine = 0;
        int diffInDays = 0;

        try {
            connection = Util.getConnection();

            Statement stm = connection.createStatement();
            ResultSet rsd = stm.executeQuery("SELECT trn_mem_id, trn_book_id, trn_issue_dt, trn_receive_dt FROM transaction_cart WHERE trn_mem_id = " + TxtMemberID.getText() + " and Chk_Rcv > 0");

            while (rsd.next()) {
                fine = 0;
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO lib_account(trn_mem_id, trn_book_id, fine, book_rtn_days) VALUES ( ?, ?, ?, ?)");
                pstmt.setInt(1, rsd.getInt(1));
                pstmt.setInt(2, rsd.getInt(2));

                Date newerDate = rsd.getDate(4);
                Date olderDate = rsd.getDate(3);
                diffInDays = (int) ((newerDate.getTime() - olderDate.getTime()) / (1000 * 60 * 60 * 24));
                System.out.println(diffInDays);
                PreparedStatement psmnt = connection.prepareStatement("select fine_amount, fine_time, max_issue_day from memberrules where mem_id = ?");
                psmnt.setInt(1, rsd.getInt(1));
                ResultSet rs1 = psmnt.executeQuery();
                if (rs1.next()) {
                    System.out.println("days " + (rs1.getString(2).equalsIgnoreCase("Weekly") && diffInDays > rs1.getInt(3)));
                    if (rs1.getString(2).equalsIgnoreCase("Daily") && diffInDays > rs1.getInt(3)) {
                        int fineamount = Integer.parseInt(rs1.getString("fine_amount"));
                        fine += fineamount * (diffInDays - Integer.parseInt(rs1.getString(3)));
                        System.out.println("fine " + fine);

                    } else if (rs1.getString(2).equalsIgnoreCase("Weekly") && diffInDays > rs1.getInt(3)) {
                        int fineamount = Integer.parseInt(rs1.getString(1));
                        System.out.println(" fine ..... " + Math.ceil(((double) diffInDays - Double.parseDouble(rs1.getString(3))) / 7));
                        fine += fineamount * (int) Math.ceil(((double) diffInDays - Double.parseDouble(rs1.getString(3))) / 7);
                        System.out.println("fine " + fine);

                    } else if (rs1.getString(2).equalsIgnoreCase("Monthly") && diffInDays > rs1.getInt(31)) {
                        int fineamount = Integer.parseInt(rs1.getString("fine_amount"));
                        fine += fineamount * (int) Math.ceil(((double) diffInDays - Double.parseDouble(rs1.getString(3))) / 30);
                        System.out.println("fine " + fine);
                    }
                }
                pstmt.setInt(3, fine);
                pstmt.setInt(4, diffInDays);
                if(fine > 0){
                int a = pstmt.executeUpdate();
                if (a > 0) {
                    System.out.println("lib account updated");
                } else {
                    System.out.println("lib account problem.");
                    return;
                }
                updateDue();
                }
                else{
                pstmt.cancel();
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateDue() {
        try{
        PreparedStatement psmnt = connection.prepareStatement("select sum(fine), sum(paid_amount) from lib_account where trn_mem_id = ?");
        psmnt.setInt(1, Integer.parseInt(TxtMemberID.getText()) );
        ResultSet rsfine = psmnt.executeQuery();
        if(rsfine.next())
        {
            int totalDue = rsfine.getInt(1) - rsfine.getInt(2);
            psmnt = connection.prepareStatement("Update lib_account set due = ? where trn_mem_id = ?");
            psmnt.setInt(1, totalDue);
            psmnt.setInt(2, Integer.parseInt(TxtMemberID.getText()));
            int s = psmnt.executeUpdate();
            if(s > 0)
            {
                System.out.println("lib due updated");
            }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CmdClear;
    private javax.swing.JLabel CmdMemberDetails;
    private javax.swing.JLabel CmdReceiveBook;
    private javax.swing.JLabel LblBookID;
    private javax.swing.JTextField TxtBookDetails;
    private javax.swing.JTextField TxtMemberID;
    private javax.swing.JTextField TxtMemberName;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
