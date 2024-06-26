package Com.Dufins.Developer.Admission.Forms;

import Com.Dufins.Developer.LoginPkg.Login;
import Util.Coloumnautosizer;
import Util.NumToWords;
import Util.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AddmissionReciept extends javax.swing.JFrame implements Printable {

   
    Connection con = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;
    String user = null;
    String chequeno = null;
    String cashammount = null;
    String ddno = null;
    String timeset = null;
    ArrayList<String> e = new ArrayList<>();
    String pass = null;
    String rcpno = null;
    String rollno = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    double acctotal;
    private int currentSecond;
    private Calendar calendar;
    double tutiondue = 0, hosteldue = 0, messdue = 0, examdue = 0, uniformdue = 0, busdue = 0, otherdue = 0, wholedue = 0;

    public AddmissionReciept() {
        initComponents();
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("/Image/icon_2.png"));
        } catch (IOException ex) {
        }
        setIconImage(im);
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        Dialog_DateFormat = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        combo_dateformat = new javax.swing.JComboBox();
        txt_dateformat = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        Button_Set = new javax.swing.JButton();
        db_DD = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_DDNo = new javax.swing.JTextField();
        txt_DDBank = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_DDAmount = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dd = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        dc_dd = new com.toedter.calendar.JDateChooser();
        lbl_word = new javax.swing.JLabel();
        db_Chq = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_chqno = new javax.swing.JTextField();
        txt_chqbank = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_chqamount = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_chq = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        db_chqdate = new com.toedter.calendar.JDateChooser();
        db_cash = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        txt_cash = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbl_icon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_fname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_sem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_cash = new javax.swing.JCheckBox();
        cb_cheque = new javax.swing.JCheckBox();
        cb_dd = new javax.swing.JCheckBox();
        txt_lname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_add = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        year_from = new com.toedter.calendar.JYearChooser();
        year_to = new com.toedter.calendar.JYearChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_mname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        lbl_rupee = new javax.swing.JLabel();
        lbl_select = new javax.swing.JLabel();
        lbl_acc = new javax.swing.JLabel();
        lbl_payment = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_due = new javax.swing.JTextField();
        lbl_mode = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbl_rupee1 = new javax.swing.JLabel();
        rb_select = new javax.swing.JRadioButton();
        lbl_eroll = new javax.swing.JLabel();
        txt_eroll = new javax.swing.JTextField();
        txt_acc = new javax.swing.JComboBox();
        rb_macc = new javax.swing.JRadioButton();
        panel_acc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_tfee = new javax.swing.JTextField();
        txt_hostelfee = new javax.swing.JTextField();
        txt_messfee = new javax.swing.JTextField();
        txt_examfee = new javax.swing.JTextField();
        txt_uniformcharge = new javax.swing.JTextField();
        txt_busfare = new javax.swing.JTextField();
        txt_other = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_sem = new javax.swing.JComboBox();
        lbl_eroll1 = new javax.swing.JLabel();
        txt_rollno = new javax.swing.JTextField();
        txt_payment = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmb_course = new javax.swing.JComboBox();
        rbDue = new javax.swing.JRadioButton();
        lbl_rcpno = new javax.swing.JTextField();
        rb_rcp = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Date = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu_time = new javax.swing.JMenu();

        Dialog_DateFormat.setTitle("Billing Software Version 1.2");
        Dialog_DateFormat.setUndecorated(true);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Format", 2, 3, new java.awt.Font("Arial", 1, 18), new java.awt.Color(102, 0, 0))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel27.setText("Select Date Format");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel28.setText(" Date Format Sample");

        combo_dateformat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "dd/MM/yy", "dd.MM.yy", "dd-MM-yy", "dd/MM/YYYY", "dd.MM.YYYY", "dd-MM-YYYY", "dd-MMM-yy", "dd.MMM.yy", "dd/MMM/yy", "dd-MMM-YYYY", "dd/MMM/YYYY", "dd.MMM.YYYY" }));
        combo_dateformat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_dateformatActionPerformed(evt);
            }
        });
        combo_dateformat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo_dateformatKeyPressed(evt);
            }
        });

        txt_dateformat.setEditable(false);
        txt_dateformat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateformatActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel29.setText("Legend");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("DD - Day");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel31.setText("MM- Month");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel34.setText("YY- Year");

        Button_Set.setText("Set");
        Button_Set.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SetActionPerformed(evt);
            }
        });
        Button_Set.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Button_SetKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Button_Set))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_dateformat)
                    .addComponent(txt_dateformat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Set)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel34)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Dialog_DateFormatLayout = new javax.swing.GroupLayout(Dialog_DateFormat.getContentPane());
        Dialog_DateFormat.getContentPane().setLayout(Dialog_DateFormatLayout);
        Dialog_DateFormatLayout.setHorizontalGroup(
            Dialog_DateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Dialog_DateFormatLayout.setVerticalGroup(
            Dialog_DateFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        db_DD.setTitle("Enter D.D. Details");
        db_DD.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                db_DDWindowClosing(evt);
            }
        });
        db_DD.getContentPane().setLayout(new javax.swing.BoxLayout(db_DD.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setText("No. :-");

        jLabel17.setText("Bank Name:-");

        jLabel18.setText("Amount :-");

        txt_DDAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DDAmountActionPerformed(evt);
            }
        });

        table_dd.setModel(new javax.swing.table.DefaultTableModel(
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
        table_dd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ddMouseClicked(evt);
            }
        });
        table_dd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_ddKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_dd);

        jLabel23.setText("Date:-");

        dc_dd.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DDNo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_DDBank, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(dc_dd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(txt_DDAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel23)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_DDNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_DDBank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_DDAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dc_dd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        db_DD.getContentPane().add(jPanel2);

        lbl_word.setText("jLabel18");

        db_Chq.setTitle("Enter Chaque Details");
        db_Chq.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                db_ChqWindowClosing(evt);
            }
        });
        db_Chq.getContentPane().setLayout(new javax.swing.BoxLayout(db_Chq.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("No. :-");

        jLabel20.setText("Bank Name");

        jLabel21.setText("Amount :-");

        txt_chqamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chqamountActionPerformed(evt);
            }
        });

        table_chq.setModel(new javax.swing.table.DefaultTableModel(
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
        table_chq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_chqMouseClicked(evt);
            }
        });
        table_chq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_chqKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table_chq);

        jLabel22.setText("Date:-");

        db_chqdate.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_chqno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_chqbank, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(db_chqdate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(txt_chqamount, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_chqno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_chqbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_chqamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(db_chqdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        db_Chq.getContentPane().add(jPanel3);

        db_cash.setTitle("Enter cash amount");
        db_cash.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                db_cashWindowClosing(evt);
            }
        });
        db_cash.getContentPane().setLayout(new javax.swing.BoxLayout(db_cash.getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cashActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cash, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        db_cash.getContentPane().add(jPanel4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("(Reciept Maker) cmsDufins Version 1.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nilai.png"))); // NOI18N

        jButton1.setText("Print/Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        lbl_fname.setText("First Name :");

        jLabel4.setText("Address :");

        lbl_course.setText("Course Programme :");

        lbl_sem.setText("Semester :");

        jLabel7.setText("Session :");

        cb_cash.setBackground(new java.awt.Color(255, 255, 255));
        cb_cash.setText("Cash");
        cb_cash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_cashMouseClicked(evt);
            }
        });
        cb_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cashActionPerformed(evt);
            }
        });

        cb_cheque.setBackground(new java.awt.Color(255, 255, 255));
        cb_cheque.setText("Cheque");
        cb_cheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_chequeActionPerformed(evt);
            }
        });

        cb_dd.setBackground(new java.awt.Color(255, 255, 255));
        cb_dd.setText("Demand Draft");
        cb_dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ddActionPerformed(evt);
            }
        });

        jLabel8.setText("Last Name :");

        year_from.setBackground(new java.awt.Color(255, 255, 255));
        year_from.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        year_from.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                year_fromPropertyChange(evt);
            }
        });

        year_to.setBackground(new java.awt.Color(255, 255, 255));
        year_to.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setText("--");

        jLabel11.setText("Middle Name :");

        txt_mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mnameActionPerformed(evt);
            }
        });

        jLabel1.setText("No.");

        txt_total.setText("0");
        txt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totalKeyReleased(evt);
            }
        });

        lbl_rupee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ruppee.png"))); // NOI18N

        lbl_select.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/select.png"))); // NOI18N

        lbl_acc.setText("Account :");

        lbl_payment.setText("Payment :");

        jLabel12.setText("Balance Due :");

        txt_due.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_dueMouseEntered(evt);
            }
        });

        lbl_mode.setText("Mode Of Payment :");

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbl_rupee1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ruppee.png"))); // NOI18N

        rb_select.setBackground(new java.awt.Color(255, 255, 255));
        rb_select.setText("New Admission");
        rb_select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_selectActionPerformed(evt);
            }
        });

        lbl_eroll.setText("Enrollment No. :");

        txt_eroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_erollActionPerformed(evt);
            }
        });

        txt_acc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tuition Fee", "Hostel Fee", "Mess Fee", "Exam Fee", "Uniform Charges", "Bus Fare", "Other" }));
        txt_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_accActionPerformed(evt);
            }
        });

        rb_macc.setBackground(new java.awt.Color(255, 255, 255));
        rb_macc.setText("Multiple Account");
        rb_macc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_maccActionPerformed(evt);
            }
        });

        panel_acc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tuition Fee");

        jLabel3.setText("Hostel Fee");

        jLabel5.setText("Mess Fee");

        jLabel6.setText("Exam Fee");

        jLabel9.setText("Uniform Charges");

        jLabel13.setText("Bus Fare");

        txt_tfee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tfeeFocusGained(evt);
            }
        });
        txt_tfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tfeeKeyReleased(evt);
            }
        });

        txt_hostelfee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_hostelfeeFocusGained(evt);
            }
        });
        txt_hostelfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_hostelfeeKeyReleased(evt);
            }
        });

        txt_messfee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_messfeeFocusGained(evt);
            }
        });
        txt_messfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_messfeeKeyReleased(evt);
            }
        });

        txt_examfee.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_examfeeFocusGained(evt);
            }
        });
        txt_examfee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_examfeeKeyReleased(evt);
            }
        });

        txt_uniformcharge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_uniformchargeFocusGained(evt);
            }
        });
        txt_uniformcharge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_uniformchargeKeyReleased(evt);
            }
        });

        txt_busfare.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_busfareFocusGained(evt);
            }
        });
        txt_busfare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busfareKeyReleased(evt);
            }
        });

        txt_other.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_otherFocusGained(evt);
            }
        });
        txt_other.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_otherKeyReleased(evt);
            }
        });

        jLabel14.setText("Others");

        javax.swing.GroupLayout panel_accLayout = new javax.swing.GroupLayout(panel_acc);
        panel_acc.setLayout(panel_accLayout);
        panel_accLayout.setHorizontalGroup(
            panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tfee, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_accLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hostelfee, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_messfee, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_examfee, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_uniformcharge, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(txt_busfare, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_other, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6))
        );
        panel_accLayout.setVerticalGroup(
            panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_accLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_accLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hostelfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_messfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_examfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_uniformcharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_busfare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_other, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_sem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));

        lbl_eroll1.setText("Roll No. :");

        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });

        txt_payment.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_paymentPropertyChange(evt);
            }
        });
        txt_payment.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                txt_paymentVetoableChange(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Total :-");

        cmb_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_courseActionPerformed(evt);
            }
        });

        rbDue.setBackground(new java.awt.Color(255, 255, 255));
        rbDue.setText("Total Due");
        rbDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDueActionPerformed(evt);
            }
        });

        lbl_rcpno.setEditable(false);
        lbl_rcpno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_rcpno.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbl_rcpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_rcpnoActionPerformed(evt);
            }
        });

        rb_rcp.setBackground(new java.awt.Color(255, 255, 255));
        rb_rcp.setText("Edit");
        rb_rcp.setFocusPainted(false);
        rb_rcp.setFocusable(false);
        rb_rcp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_rcpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_rcpno, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_rcp))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_acc)
                                                .addComponent(lbl_fname)
                                                .addComponent(jLabel4)
                                                .addComponent(rb_select))
                                            .addGap(19, 19, 19))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(lbl_course)
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rb_macc)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addComponent(lbl_eroll))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txt_fname)
                                                            .addComponent(cmb_course, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(10, 10, 10)))))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txt_eroll)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(year_from, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(year_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(lbl_sem)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(txt_sem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addComponent(jLabel8)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lbl_eroll1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(txt_rollno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(txt_add, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txt_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(cb_cash)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_select)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbl_mode))
                                .addComponent(cb_cheque)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(133, 133, 133)
                                    .addComponent(panel_acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txt_payment)
                                    .addGap(40, 40, 40)
                                    .addComponent(lbl_payment)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_rupee)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_rupee1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_due, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rbDue)
                                    .addGap(130, 130, 130))
                                .addComponent(jLabel15)
                                .addComponent(cb_dd))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_icon, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(rb_rcp)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_rcpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(rb_select)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_fname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_eroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_eroll1)
                            .addComponent(txt_rollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_eroll))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_sem)
                                .addComponent(txt_sem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(year_from, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(year_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(lbl_course)
                                    .addComponent(cmb_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(22, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_acc)
                    .addComponent(txt_acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rb_macc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_mode)
                            .addComponent(lbl_select))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_cash)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_cheque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_dd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15))
                    .addComponent(panel_acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_payment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rupee1)
                    .addComponent(lbl_rupee)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(txt_due, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbDue))
                    .addComponent(lbl_payment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        jMenu_Date.setForeground(new java.awt.Color(0, 0, 204));
        jMenu_Date.setText("Date");
        jMenu_Date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu_DateMousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu_Date);

        jMenu1.setText("l");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu_time.setForeground(new java.awt.Color(0, 0, 204));
        jMenu_time.setText("Time");
        jMenu_time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuBar1.add(jMenu_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    
    @SuppressWarnings("empty-statement")
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) { 
             
            return NO_SUCH_PAGE;
        }

       
        String fname;
        String mname;
        String lname;
        String name;
        String sesfrom = Integer.toString(year_from.getYear());
        String sesto = Integer.toString(year_to.getYear());;
        String sem = txt_sem.getSelectedItem().toString();
        String session = sesfrom + "-" + sesto;

        if (txt_fname.getText() != null) {
            fname = txt_fname.getText();
        } else {
            fname = "";
        }
        if (txt_mname.getText() != null) {
            mname = txt_mname.getText();
        } else {
            mname = "";
        }
        if (txt_lname.getText() != null) {
            lname = txt_lname.getText();
        } else {
            lname = "";
        }
        name = fname + " " + mname + " " + lname;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        Font font = new Font("Tahoma", Font.BOLD, 17);
        g2d.setFont(font);

        g.drawString("MONEY RECIEPT", 225, 151);
        int height = lbl_icon.getHeight();
        int width = lbl_icon.getWidth();

        lbl_icon.paint(g.create(30, 20, width, height));
        lbl_rupee.paint(g.create(440, 320, width, height));

        Font font1 = new Font("Tahoma", Font.PLAIN, 10);
        g2d.setFont(font1);
        g.drawString("Date _________________", 50, 180);
        g.drawString(jMenu_Date.getText(), 80, 180);
        g.drawString("No.", 500, 180);
        g.drawString("Recieved From _________________________________________________________________________________", 50, 210);
        g.drawString(name, 120, 210);
        g.drawString("Rs. in Words ___________________________________________________________________________________", 50, 240);
        g.drawString(lbl_word.getText(), 120, 240);
        g.drawString("Address _______________________________________________________________________________________", 50, 270);
        g.drawString(txt_add.getText(), 90, 270);
        g.drawString("Course Programme ____________________________Session______________________Semester______________", 50, 300);
        g.drawString(cmb_course.getSelectedItem().toString(), 140, 300);
        g.drawString(txt_total.getText(), 480, 340);
        g.drawString(session, 340, 300);
        g.drawString(sem, 500, 300);
        g.drawRect(60, 320, 80, 20);
        g.drawRect(60, 350, 80, 20);
        g.drawRect(60, 380, 80, 20);
        g.drawString("Account", 65, 335);
        g.drawString("Payment", 65, 365);
        g.drawString("Balance Due", 65, 395);
        g.drawRect(145, 320, 80, 20);
        g.drawRect(145, 350, 80, 20);
        g.drawRect(145, 380, 80, 20);
        g.drawRect(230, 320, 30, 20);
        g.drawRect(230, 350, 30, 20);
        g.drawRect(230, 380, 30, 20);
        g.drawOval(265, 320, 20, 20);
        g.drawOval(265, 350, 20, 20);
        g.drawOval(265, 380, 20, 20);
        g.drawString("Cash", 290, 335);
        g.drawString("Cheque", 290, 365);
        g.drawString("Demand Draft", 290, 395);
        if (cb_cash.isSelected()) {
            lbl_select.paint(g.create(265, 320, width, height));
        }
        if (cb_cheque.isSelected()) {
            lbl_select.paint(g.create(265, 350, width, height));
        }
        if (cb_dd.isSelected()) {
            lbl_select.paint(g.create(265, 380, width, height));
        }
        if (rb_macc.isSelected()) {
            g.drawString("Multiple Acc".toString(), 150, 335);
        } else {
            g.drawString(txt_acc.getSelectedItem().toString(), 150, 335);
        }
        g.drawString(txt_total.getText(), 150, 365);
        Font font2 = new Font("Tahoma", Font.BOLD, 8);
        g2d.setFont(font2);
        g.drawString("Thakurgaon, Ranchi, Jharkhand. Phone : 06531-277785. E-mail : info@nilai.in . Website :www.nilai.in", 80, 440);
        Font font20 = new Font("Tahoma", Font.BOLD, 10);
        g2d.setFont(font20);
        g.drawString("Authorised Signatory", 460, 400);

        Font font3 = new Font("Tahoma", Font.PLAIN, 7);
        g2d.setFont(font3);
        Font f = new Font("Tahoma", Font.BOLD, 9);
        g2d.setFont(f);
        g.drawString(lbl_rcpno.getText(), 520, 180);
        Graphics2D g1 = (Graphics2D) g;
        g1.translate(pf.getImageableX(), pf.getImageableY());
        Font f5 = new Font("Tahoma", Font.PLAIN, 1);
        g1.setFont(f5);

        g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        g.drawRect(440, 320, 120, 30);
        g.drawLine(465, 320, 465, 350);
        g.drawLine(0, 130, 600, 130);
        g.drawLine(0, 430, 600, 430);

       
        return PAGE_EXISTS;
    }

    public void updaterollno() {
        if (rb_select.isSelected()) {
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select rollno from codelist ");
                if (rs.next()) {
                    int roll = rs.getInt(1);
                    roll++;
                    stmt.executeUpdate("update codelist set rollno=" + roll + "");
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }

    public void validation() {

        String fname = txt_fname.getText();

        String course = cmb_course.getSelectedItem().toString();

        String sem = txt_sem.getSelectedItem().toString();

        String total = txt_total.getText();

        e.removeAll(e);
        if (fname.isEmpty()) {
            e.add("1");
        } else {

            lbl_fname.setForeground(Color.BLACK);
            e.remove("1");
        }
        if (course.isEmpty()) {
            e.add("2");
        } else {
            lbl_course.setForeground(Color.BLACK);
            e.remove("2");
        }

        if (sem.isEmpty()) {
            e.add("3");
        } else {
            lbl_sem.setForeground(Color.BLACK);
            e.remove("3");
        }

        if (txt_acc.getSelectedItem().toString().isEmpty()) {
            e.add("4");
        } else {
            lbl_acc.setForeground(Color.BLACK);
            e.remove("4");
        }
        if (total.equals("0")) {
            e.add("5");
        } else {
            lbl_payment.setForeground(Color.BLACK);
            e.remove("5");
        }
        if (cb_cash.isSelected() || cb_cheque.isSelected() || cb_dd.isSelected()) {
            lbl_mode.setForeground(Color.BLACK);
            e.remove("6");

        } else {
            e.add("6");
        }
        for (int i = 0; i < e.size(); i++) {
            String item = e.get(i);
            switch (item) {
                case "1":
                    lbl_fname.setForeground(Color.red);
                    break;
                case "2":
                    lbl_course.setForeground(Color.red);
                    break;
                case "3":
                    lbl_sem.setForeground(Color.red);
                    break;
                case "4":
                    lbl_acc.setForeground(Color.red);
                    break;
                case "5":
                    lbl_payment.setForeground(Color.red);
                    break;
                case "6":
                    lbl_mode.setForeground(Color.red);
                    break;
            }
        }
    }

    public void setblank() {
        //String rcpno= lbl_rcpno.setText("");
        txt_fname.setText("");
        txt_mname.setText("");
        txt_lname.setText("");
        txt_add.setText("");
        txt_sem.setSelectedIndex(0);
        txt_acc.setSelectedIndex(0);
        txt_total.setText("0");
        txt_due.setText("");
        cb_cash.setSelected(false);
        cb_cheque.setSelected(false);
        cb_dd.setSelected(false);
        txt_cash.setText("");
        txt_payment.setText("");
        txt_total.setText("");
        txt_tfee.setText("");
        txt_busfare.setText("");
        cmb_course.setSelectedIndex(0);
        txt_due.setText("");
        txt_eroll.setText("");
        txt_examfee.setText("");
        txt_hostelfee.setText("");
        txt_messfee.setText("");
        txt_other.setText("");
        txt_payment.setText("");
        txt_uniformcharge.setText("");

    }

    public void savedata() {
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("insert into pay_report(rcpno ,rollno ,enrollmentno ,firstname ,middlename ,lastname,course ,session,semester,address,tutionfee,hostelfee,messfee,examfee,uniformcharge,busfare,other,amount,rdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, lbl_rcpno.getText());

            if (!txt_rollno.getText().isEmpty()) {
                pstmt.setString(2, "" + txt_rollno.getText() + "");
            } else {
                pstmt.setString(2, "");
            }
            if (!txt_eroll.getText().isEmpty()) {
                pstmt.setString(3, "" + txt_eroll.getText() + "");
            } else {
                pstmt.setString(3, "");
            }
            if (!txt_fname.getText().isEmpty()) {
                pstmt.setString(4, "" + txt_fname.getText() + "");
            } else {
                pstmt.setString(4, "");
            }
            if (!txt_mname.getText().isEmpty()) {
                pstmt.setString(5, "" + txt_mname.getText() + "");
            } else {
                pstmt.setString(5, "");

            }
            if (!txt_lname.getText().isEmpty()) {
                pstmt.setString(6, "" + txt_lname.getText() + "");
            } else {
                pstmt.setString(6, "");
            }
            pstmt.setString(7, cmb_course.getSelectedItem().toString());

            pstmt.setString(8, String.valueOf(year_from.getYear()) + "-" + String.valueOf(year_to.getYear()));

            pstmt.setString(9, txt_sem.getSelectedItem().toString());
            if (!txt_add.getText().isEmpty()) {
                pstmt.setString(10, "" + txt_add.getText() + "");
            } else {
                pstmt.setString(10, "");
            }
            //account fields start
            if (rb_macc.isSelected()) {
                if (!txt_tfee.getText().isEmpty()) {
                    pstmt.setString(11, "" + txt_tfee.getText() + "");
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (txt_hostelfee.getText().trim().length() != 0) {
                    pstmt.setString(12, txt_hostelfee.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (!txt_messfee.getText().isEmpty()) {
                    pstmt.setString(13, txt_messfee.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (!txt_examfee.getText().isEmpty()) {
                    pstmt.setString(14, txt_examfee.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (!txt_uniformcharge.getText().isEmpty()) {
                    pstmt.setString(15, txt_uniformcharge.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (!txt_busfare.getText().isEmpty()) {
                    pstmt.setString(16, txt_busfare.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
                if (!txt_other.getText().isEmpty()) {
                    pstmt.setString(17, txt_other.getText());
                } else {
                    pstmt.setString(17, "0.0");
                }
            } else {
                if (txt_acc.getSelectedItem().equals("Tuition Fee")) {
                    pstmt.setString(11, "" + txt_total.getText() + "");
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Hostel Fee")) {
                    pstmt.setString(12, txt_total.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Mess Fee")) {
                    pstmt.setString(13, txt_total.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Exam Fee")) {
                    pstmt.setString(14, txt_total.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Uniform Charges")) {
                    pstmt.setString(15, txt_total.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Bus Fare")) {
                    pstmt.setString(16, txt_total.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Other")) {
                    pstmt.setString(17, txt_total.getText());
                } else {
                    pstmt.setString(17, "0.0");
                }
            }

            if (!txt_total.getText().isEmpty()) {
                pstmt.setString(18, txt_total.getText());
            } else {
                pstmt.setString(18, "");
            }

            pstmt.setString(19, jMenu_Date.getText());

            int a = pstmt.executeUpdate();
            if (a > 0) {
                System.out.println("Pay Report successfully updated.");
            }

            int count = 0, count1 = 0;
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from  chequecart ");
            while (rs.next()) {
                count += 1;
            }
            rs = stmt.executeQuery("select * from ddcart ");
            while (rs.next()) {
                count1 += 1;
            }
            if (count1 != 0) {
                stmt.executeUpdate("update ddcart set rcpno='" + lbl_rcpno.getText().trim() + "', rollno='" + txt_rollno.getText().trim() + "', enrollno = '" + txt_eroll.getText().trim() + "' where rcpno='rcpno'  ");
                stmt.executeUpdate("insert into dd select * from ddcart");
                stmt.executeUpdate("truncate table ddcart");
            }
            if (count != 0) {
                stmt.executeUpdate("update chequecart set rcpno='" + lbl_rcpno.getText().trim() + "', rollno='" + txt_rollno.getText().trim() + "', enrollno = '" + txt_eroll.getText().trim() + "'  where rcpno='rcpno'");
                stmt.executeUpdate("insert into cheque select * from chequecart");
                stmt.executeUpdate("truncate table chequecart");
            }

            JOptionPane.showMessageDialog(null, "Reciept added sucessfully");

            retrievChequeCart();
            retrievDDCart();
            insertRcpchecker();
            setblank();
            retrieve_rcpno();

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.toString());

        }
    }

    public void printReciept() {

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
                savedata();
                updatereciptNo();
                retrieve_rcpno();
                updaterollno();
                retrieve_rollno();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
                System.exit(0);
            }
        }


    }

    public void enterdetails() {
        try {
            try (Connection con1 = Util.getConnection()) {
                con1.setAutoCommit(false);
                pstmt = con1.prepareStatement("Insert into student_details(roll_number, first_name, middle_name, last_name, course, semester, session) values(?,?,?,?,?,?,?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                pstmt.setString(2, txt_fname.getText().trim());
                pstmt.setString(3, txt_mname.getText().trim());
                pstmt.setString(4, txt_lname.getText().trim());
                pstmt.setString(5, cmb_course.getSelectedItem().toString());
                pstmt.setString(6, txt_sem.getSelectedItem().toString());
                pstmt.setString(7, year_from.getYear() + "-" + year_to.getYear());
                int b = pstmt.executeUpdate();
                if (b > 0) {
                    System.out.println("Student Details successfully updated.");
                }

                pstmt = con1.prepareStatement("Insert into fee_details(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int c = pstmt.executeUpdate();
                if (c > 0) {
                    System.out.println("Fee Details successfully updated.");
                }


                pstmt = con1.prepareStatement("Insert into student_address(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int d = pstmt.executeUpdate();
                if (d > 0) {
                    System.out.println("Student Address successfully updated.");
                }

                pstmt = con1.prepareStatement("Insert into educational_details(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int ef = pstmt.executeUpdate();
                if (ef > 0) {
                    System.out.println("Educational Details successfully updated.");
                }

                pstmt = con1.prepareStatement("Insert into submitteddoc(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int f = pstmt.executeUpdate();
                if (f > 0) {
                    System.out.println("Submit Document successfully updated.");
                }

                pstmt = con1.prepareStatement("Insert into student_image(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int g = pstmt.executeUpdate();
                if (g > 0) {
                    System.out.println("Student Image successfully updated.");
                }

                pstmt = con1.prepareStatement("Insert into due(roll_number) values(?)");
                pstmt.setString(1, txt_rollno.getText().trim());
                int h = pstmt.executeUpdate();
                if (h > 0) {
                    System.out.println("Due detail successfully submitted");
                }

                con1.commit();
                pstmt.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            System.exit(0);
        }

    }

    public void insertRcpchecker() {
        try {

            con = Util.getConnection();
            pstmt = con.prepareStatement("insert into reciept_checker(rcpno ,rollno ,enrollmentno ,firstname ,middlename ,lastname,course ,session,semester,address,tutionfee,hostelfee,messfee,examfee,uniformcharge,busfare,other,amount,rdate) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, lbl_rcpno.getText());

            if (!txt_rollno.getText().isEmpty()) {
                pstmt.setString(2, "" + txt_rollno.getText() + "");
            } else {
                pstmt.setString(2, "");
            }
            if (!txt_eroll.getText().isEmpty()) {
                pstmt.setString(3, "" + txt_eroll.getText() + "");
            } else {
                pstmt.setString(3, "");
            }
            if (!txt_fname.getText().isEmpty()) {
                pstmt.setString(4, "" + txt_fname.getText() + "");
            } else {
                pstmt.setString(4, "");
            }
            if (!txt_mname.getText().isEmpty()) {
                pstmt.setString(5, "" + txt_mname.getText() + "");
            } else {
                pstmt.setString(5, "");

            }
            if (!txt_lname.getText().isEmpty()) {
                pstmt.setString(6, "" + txt_lname.getText() + "");
            } else {
                pstmt.setString(6, "");
            }
            pstmt.setString(7, cmb_course.getSelectedItem().toString());

            pstmt.setString(8, String.valueOf(year_from.getYear()) + "-" + String.valueOf(year_to.getYear()));

            pstmt.setString(9, txt_sem.getSelectedItem().toString());
            if (!txt_add.getText().isEmpty()) {
                pstmt.setString(10, "" + txt_add.getText() + "");
            } else {
                pstmt.setString(10, "");
            }
            //account fields start
            if (rb_macc.isSelected()) {
                if (!txt_tfee.getText().isEmpty()) {
                    pstmt.setString(11, "" + txt_tfee.getText() + "");
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (txt_hostelfee.getText().trim().length() != 0) {
                    pstmt.setString(12, txt_hostelfee.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (!txt_messfee.getText().isEmpty()) {
                    pstmt.setString(13, txt_messfee.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (!txt_examfee.getText().isEmpty()) {
                    pstmt.setString(14, txt_examfee.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (!txt_uniformcharge.getText().isEmpty()) {
                    pstmt.setString(15, txt_uniformcharge.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (!txt_busfare.getText().isEmpty()) {
                    pstmt.setString(16, txt_busfare.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
                if (!txt_other.getText().isEmpty()) {
                    pstmt.setString(17, txt_other.getText());
                } else {
                    pstmt.setString(17, "0.0");
                }
            } else {
                if (txt_acc.getSelectedItem().equals("Tuition Fee")) {
                    pstmt.setString(11, "" + txt_total.getText() + "");
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Hostel Fee")) {
                    pstmt.setString(12, txt_total.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Mess Fee")) {
                    pstmt.setString(13, txt_total.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Exam Fee")) {
                    pstmt.setString(14, txt_total.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Uniform Charges")) {
                    pstmt.setString(15, txt_total.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Bus Fare")) {
                    pstmt.setString(16, txt_total.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Other")) {
                    pstmt.setString(17, txt_total.getText());
                } else {
                    pstmt.setString(17, "0.0");
                }
            }
            //account fields ends
            if (!txt_total.getText().isEmpty()) {
                pstmt.setString(18, txt_total.getText());
            } else {
                pstmt.setString(18, "");
            }

            pstmt.setString(19, jMenu_Date.getText());

            int a = pstmt.executeUpdate();
            if (a > 0) {
                System.out.println("reciept_checker successfully updated.");
            }
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void updatepay_report() {
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("update pay_report set rollno=? ,enrollmentno=? ,firstname=? ,middlename=? ,lastname=?,course=? ,session=?,semester=?,address=?,tutionfee=?,hostelfee=?,messfee=?,examfee=?,uniformcharge=?,busfare=?,other=?,amount=?,rdate=? where rcpno = ?");


            if (!txt_rollno.getText().isEmpty()) {
                pstmt.setString(1, "" + txt_rollno.getText() + "");
            } else {
                pstmt.setString(1, "");
            }
            if (!txt_eroll.getText().isEmpty()) {
                pstmt.setString(2, "" + txt_eroll.getText() + "");
            } else {
                pstmt.setString(2, "");
            }
            if (!txt_fname.getText().isEmpty()) {
                pstmt.setString(3, "" + txt_fname.getText() + "");
            } else {
                pstmt.setString(3, "");
            }
            if (!txt_mname.getText().isEmpty()) {
                pstmt.setString(4, "" + txt_mname.getText() + "");
            } else {
                pstmt.setString(4, "");

            }
            if (!txt_lname.getText().isEmpty()) {
                pstmt.setString(5, "" + txt_lname.getText() + "");
            } else {
                pstmt.setString(5, "");
            }
            pstmt.setString(6, cmb_course.getSelectedItem().toString());

            pstmt.setString(7, String.valueOf(year_from.getYear()) + "-" + String.valueOf(year_to.getYear()));

            pstmt.setString(8, txt_sem.getSelectedItem().toString());
            if (!txt_add.getText().isEmpty()) {
                pstmt.setString(9, "" + txt_add.getText() + "");
            } else {
                pstmt.setString(9, "");
            }
            //account fields start
            if (rb_macc.isSelected()) {
                if (!txt_tfee.getText().isEmpty()) {
                    pstmt.setString(10, "" + txt_tfee.getText() + "");
                } else {
                    pstmt.setString(10, "0.0");
                }
                if (txt_hostelfee.getText().trim().length() != 0) {
                    pstmt.setString(11, txt_hostelfee.getText());
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (!txt_messfee.getText().isEmpty()) {
                    pstmt.setString(12, txt_messfee.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (!txt_examfee.getText().isEmpty()) {
                    pstmt.setString(13, txt_examfee.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (!txt_uniformcharge.getText().isEmpty()) {
                    pstmt.setString(14, txt_uniformcharge.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (!txt_busfare.getText().isEmpty()) {
                    pstmt.setString(15, txt_busfare.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (!txt_other.getText().isEmpty()) {
                    pstmt.setString(16, txt_other.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
            } else {
                if (txt_acc.getSelectedItem().equals("Tuition Fee")) {
                    pstmt.setString(10, "" + txt_total.getText() + "");
                } else {
                    pstmt.setString(10, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Hostel Fee")) {
                    pstmt.setString(11, txt_total.getText());
                } else {
                    pstmt.setString(11, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Mess Fee")) {
                    pstmt.setString(12, txt_total.getText());
                } else {
                    pstmt.setString(12, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Exam Fee")) {
                    pstmt.setString(13, txt_total.getText());
                } else {
                    pstmt.setString(13, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Uniform Charges")) {
                    pstmt.setString(14, txt_total.getText());
                } else {
                    pstmt.setString(14, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Bus Fare")) {
                    pstmt.setString(15, txt_total.getText());
                } else {
                    pstmt.setString(15, "0.0");
                }
                if (txt_acc.getSelectedItem().equals("Other")) {
                    pstmt.setString(16, txt_total.getText());
                } else {
                    pstmt.setString(16, "0.0");
                }
            }
            //account fields ends
            if (!txt_total.getText().isEmpty()) {
                pstmt.setString(17, txt_total.getText());
            } else {
                pstmt.setString(17, "");
            }

            pstmt.setString(18, jMenu_Date.getText());
            pstmt.setString(19, lbl_rcpno.getText());

            int a = pstmt.executeUpdate();
            if (a > 0) {
                System.out.println("Pay Report successfully updated.");
            }
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void updateReciept() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
                /*
                 * this function used to update original pay report
                 */
                updatepay_report();
                /*
                 * this function used to insert each transaction of pay report
                 */
                insertRcpchecker();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }

    public void retrievePayreport() {
        try {
            double cheq = 0, dd = 0, cash = 0, amount = 0;
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from pay_report where rcpno = '" + lbl_rcpno.getText().trim() + "'");
            if (rs.next()) {
                txt_rollno.setText(rs.getString(2));
                txt_fname.setText(rs.getString(4));
                txt_mname.setText(rs.getString(5));
                txt_lname.setText(rs.getString(6));
                txt_add.setText(rs.getString(10));
                txt_sem.setSelectedItem(rs.getString(9));
                txt_total.setText(rs.getString(18));
                Statement stmt2 = con.createStatement();
                ResultSet rs2 = stmt2.executeQuery("select sum(amount) from chequecart where rcpno = '" + lbl_rcpno.getText().trim() + "'");
                if (rs2.next()) {
                    cheq = rs2.getString(1) == null ? 0 : Double.parseDouble(rs2.getString(1));
                }
                rs2 = stmt2.executeQuery("select sum(amount) from ddcart where rcpno = '" + lbl_rcpno.getText().trim() + "'");
                if (rs2.next()) {
                    dd = rs2.getString(1) == null ? 0 : Double.parseDouble(rs2.getString(1));
                }
                amount = Double.parseDouble(rs.getString(18));
                cash = amount - (cheq + dd);
                if (cash > 0) {
                    cb_cash.setSelected(true);
                } else {
                    cb_cash.setSelected(false);
                }
                txt_cash.setText(String.valueOf(cash));
                txt_tfee.setText(rs.getString(11));
                txt_busfare.setText(rs.getString(16));
                cmb_course.setSelectedItem(rs.getString(7));
                txt_eroll.setText(rs.getString(3));
                txt_examfee.setText(rs.getString(14));
                txt_hostelfee.setText(rs.getString(12));
                txt_messfee.setText(rs.getString(13));
                txt_other.setText(rs.getString(17));
                txt_uniformcharge.setText(rs.getString(15));
                year_from.setYear(Integer.parseInt(rs.getString(8).substring(0, 4)));
                year_to.setYear(Integer.parseInt(rs.getString(8).substring(5)));
                rs2.close();
                stmt2.close();
            } else {
                JOptionPane.showMessageDialog(this, "Reciept Number does not exist");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void retrieveCheque() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from cheque where rcpno='" + lbl_rcpno.getText().trim() + "'");
            if (rs.next()) {
                cb_cheque.setSelected(true);

            } else {
                cb_cheque.setSelected(false);
            }

            table_chq.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_chq);
            stmt.executeUpdate("truncate table chequecart");
            int a = stmt.executeUpdate("Insert into chequecart select * from cheque where rcpno='" + lbl_rcpno.getText().trim() + "'");

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());

        }
    }

    public void retrieveDD() {

        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dd where rcpno='" + lbl_rcpno.getText().trim() + "'");
            if (rs.next()) {
                cb_dd.setSelected(true);

            } else {
                cb_dd.setSelected(false);
            }
            table_dd.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            Coloumnautosizer.sizeColumnsToFit(table_dd);
            stmt.executeUpdate("truncate table ddcart");
            int a = stmt.executeUpdate("Insert into ddcart select * from dd where rcpno='" + lbl_rcpno.getText().trim() + "'");
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());

        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (rb_rcp.isSelected() == false) {
            validation();
            if (txt_eroll.getText().isEmpty() && txt_rollno.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enrollmnent number or roll number must be enterd");
            } else {
                if (e.isEmpty()) {
                    if (txt_total.getText().trim().equals(txt_payment.getText().trim())) {

                        if (rb_select.isSelected()) {
                            enterdetails();
                        }
                        printReciept();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Please check the amounts entered");
                    }
                }
            }
        } else {
            updateReciept();

        }
        storedue();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void storedue() {
        tdue();
        hdue();
        mdue();
        edue();
        udue();
        bdue();
        odue();
        totaldue();
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("update due set tdue=?, hdue=?, mdue=?, edue=?, udue=?, bdue=?, odue=?, totaldue=? where roll_number=? ");
            pstmt.setString(1, String.valueOf(tutiondue));
            pstmt.setString(2, String.valueOf(hosteldue));
            pstmt.setString(3, String.valueOf(messdue));
            pstmt.setString(4, String.valueOf(examdue));
            pstmt.setString(5, String.valueOf(uniformdue));
            pstmt.setString(6, String.valueOf(busdue));
            pstmt.setString(7, String.valueOf(otherdue));
            pstmt.setString(8, String.valueOf(wholedue));
            pstmt.setString(9, txt_rollno.getText().trim());
            int a = pstmt.executeUpdate();
            if (a > 0) {
                System.out.println("Due successfully updated");
            }
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void retrieve_rcpno() {

        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select rcpno from codelist");
            if (rs.next()) {
                rcpno = rs.getString(1);
                lbl_rcpno.setText(rcpno);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void retrieve_rollno() {
        String roll = "";
        if (rb_select.isSelected()) {
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select rollno from codelist");
                if (rs.next()) {
                    roll = rs.getString(1);
                }
                String yy = String.valueOf(year_from.getYear()).substring(2);
                String name = cmb_course.getSelectedItem().toString();
                name = name.substring(name.lastIndexOf("(")+1, name.lastIndexOf(")"));
                
                
                rollno = yy+name+roll;
                
                txt_rollno.setText(rollno);
                rs.close();
                stmt.close();
                con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }

    public void removeCarts() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("truncate table ddcart");
            stmt.executeUpdate("truncate table chequecart");
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void retrieveCourse() {
        ArrayList course = new ArrayList();
        String branch = "";
        String code = "";
        cmb_course.removeAllItems();
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("select course, code from branch");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                branch = rs.getString(1);
                code = rs.getString(2);
                course.add(branch + " (" + code + ")");
            }

            rs.close();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            ex.printStackTrace();
        }
        for (int i = 0; i < course.size(); i++) {
            cmb_course.addItem(course.get(i));
        }
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        System.out.println("sesion =" + String.valueOf(year_from.getYear()));


        rb_select.setSelected(false);

        panel_acc.setVisible(false);
        retrieveCourse();
        retrieve_rcpno();
        retrieve_rollno();
        removeCarts();
        start();
        txt_rollno.setText("");
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                Date d = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(rs.getString(1));
                String s = formatter.format(d);
                jMenu_Date.setText(s);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }//GEN-LAST:event_formWindowOpened

    private void reset() {
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }

    public void start() {
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (currentSecond == 60) {
                    reset();
                }
                timeset = String.format("%s", sdf.format(calendar.getTime()));
                currentSecond++;
                jMenu_time.setText(timeset);

            }
        }, 0, 1000);
    }

    private void jMenu_DateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu_DateMousePressed
        // TODO add your handling code here:
        int code = evt.getClickCount();
        if (code == 2) {
            Dialog_DateFormat.setBounds(350, 60, 440, 160);
            Dialog_DateFormat.setVisible(true);
        }
    }//GEN-LAST:event_jMenu_DateMousePressed
    public void dateFormat() {
        Object unit = combo_dateformat.getSelectedItem();
        String cd = unit.toString();
        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(cd);
        String s = formatter.format(d);
        txt_dateformat.setText(s);
    }
    private void combo_dateformatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_dateformatActionPerformed
        // TODO add your handling code here:
        dateFormat();
    }//GEN-LAST:event_combo_dateformatActionPerformed

    private void combo_dateformatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_dateformatKeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        if (code == java.awt.event.KeyEvent.VK_ENTER) {
            Button_Set.requestFocus();
        } else if (code == java.awt.event.KeyEvent.VK_ESCAPE) {
            Dialog_DateFormat.dispose();
        }
    }//GEN-LAST:event_combo_dateformatKeyPressed

    private void txt_dateformatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateformatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateformatActionPerformed

    public void retriveDateformat() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                Date d = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat(rs.getString(1));
                String s = formatter.format(d);
                jMenu_Date.setText(s);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void updateDateFormat() {
        Object unit = combo_dateformat.getSelectedItem();
        String cd = unit.toString();
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from dateformat");
            if (rs.next()) {
                stmt.executeUpdate("update dateformat set dateformat='" + cd + "' where dateformat='" + rs.getString(1) + "'");

            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }

    public void updatereciptNo() {

        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select rcpno from codelist ");
            if (rs.next()) {
                int recipt = rs.getInt(1);
                recipt++;
                stmt.executeUpdate("update codelist set rcpno=" + recipt + "");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }
    }
    private void Button_SetActionPerformed(java.awt.event.ActionEvent evt) {
       
        updateDateFormat();
        retriveDateformat();
        Dialog_DateFormat.dispose();
    }

    private void Button_SetKeyPressed(java.awt.event.KeyEvent evt) {
     
        int code = evt.getKeyCode();
        if (code == java.awt.event.KeyEvent.VK_ENTER) {
            updateDateFormat();
            Dialog_DateFormat.dispose();
        }
    }

    private void txt_mnameActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    @SuppressWarnings("empty-statement")
    private void txt_totalKeyReleased(java.awt.event.KeyEvent evt) {
     

        String tammount = null, total = null, disamount = null;;
        double t = 0, tot = 0, nettotal = 0, adis = 0, tdis = 0;

        
        DecimalFormat df = new DecimalFormat("0.0");
        double t2 = Double.parseDouble(df.format(t));
        double net = Double.parseDouble(df.format(nettotal));

        nettotal = Double.parseDouble(txt_total.getText());
        NumToWords w = new NumToWords();
        String word = w.convert((int) Math.round(nettotal));

        int l = word.length();
        String s1 = null;
        String s2 = null;
        if (l != 0) {
            s1 = word.substring(0, 1).toUpperCase();
            s2 = word.substring(1, l);
            lbl_word.setText(s1 + s2 + " Only");
        } else {
            lbl_word.setText("Zero Only");
        }
        System.out.println("word =" + lbl_word.getText());
    }//GEN-LAST:event_txt_totalKeyReleased

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        int keyCode = evt.getKeyCode();
        if (keyCode == java.awt.event.KeyEvent.VK_ENTER) {
            jButton1ActionPerformed(null);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setblank();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rb_selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_selectActionPerformed
        // TODO add your handling code here:
        if (rb_select.isSelected()) {
            txt_eroll.setEnabled(false);
            retrieve_rollno();
            txt_rollno.setEditable(false);
        } else {
            txt_rollno.setEditable(true);
            txt_rollno.setText("");
            txt_eroll.setEnabled(true);
        }
    }//GEN-LAST:event_rb_selectActionPerformed

    private void cb_ddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ddActionPerformed
        // TODO add your handling code here:
        if (txt_DDAmount.getText().trim().length() > 0) {
            cb_dd.setSelected(true);
        } else {
            cb_dd.setSelected(false);
        }
        db_DD.setBounds(100, 300, 700, 230);
        db_DD.setVisible(true);
        retrievDDCart();
    }//GEN-LAST:event_cb_ddActionPerformed

    public void accountsum() {
        String tuition = null, hostel = null, mess = null, exam = null, uniform = null, bus = null, others = null;


        if (txt_tfee.getText().trim().length() <= 0) {
            tuition = "0";
        } else {
            tuition = txt_tfee.getText();

        }
        if (txt_hostelfee.getText().trim().length() <= 0) {
            hostel = "0";
        } else {
            hostel = txt_hostelfee.getText();
        }
        if (txt_messfee.getText().trim().length() <= 0) {
            mess = "0";

        } else {
            mess = txt_messfee.getText();
        }
        if (txt_examfee.getText().trim().length() <= 0) {
            exam = "0";

        } else {
            exam = txt_examfee.getText();
        }
        if (txt_uniformcharge.getText().trim().length() <= 0) {
            uniform = "0";
        } else {
            uniform = txt_uniformcharge.getText();
        }
        if (txt_busfare.getText().trim().length() <= 0) {
            bus = "0";
        } else {
            bus = txt_busfare.getText();
        }
        if (txt_other.getText().trim().length() <= 0) {
            others = "0";
        } else {
            others = txt_other.getText();
        }
        acctotal = Double.parseDouble(tuition) + Double.parseDouble(hostel) + Double.parseDouble(mess) + Double.parseDouble(exam) + Double.parseDouble(uniform) + Double.parseDouble(bus) + Double.parseDouble(others);
        System.out.println("acctotal =" + acctotal);
        txt_total.setText(Double.toString(acctotal));
        txt_totalKeyReleased(null);
    }
    private void rb_maccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_maccActionPerformed
        // TODO add your handling code here:
        if (rb_macc.isSelected()) {
            accountsum();
            txt_total.setText(Double.toString(acctotal));
            panel_acc.setVisible(true);
        } else {
            db_cashWindowClosing(null);
            panel_acc.setVisible(false);
        }
    }//GEN-LAST:event_rb_maccActionPerformed

    private void cb_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cashActionPerformed
        // TODO add your handling code here:
        if (txt_cash.getText().trim().length() > 0) {
            cb_cash.setSelected(true);
        } else {
            cb_cash.setSelected(false);
        }
        db_cash.setBounds(200, 400, 200, 87);
        db_cash.setVisible(true);

    }//GEN-LAST:event_cb_cashActionPerformed

    private void cb_cashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_cashMouseClicked
        // TODO add your handling code here:
        if (txt_cash.getText().trim().length() > 0) {
            cb_cash.setSelected(true);
        } else {
            cb_cash.setSelected(false);
        }
        db_cash.setBounds(200, 400, 200, 87);
        db_cash.setVisible(true);
    }//GEN-LAST:event_cb_cashMouseClicked

    public void cashAfterClose() {
        double net = 0, ddnet = 0, chequenet = 0, cash = 0;
        String dd = null, cheque = null, cashamt = null;
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select sum(amount) from ddcart");
            while (rs.next()) {
                dd = rs.getString(1);
            }
            rs = stmt.executeQuery("select sum(amount) from chequecart");
            while (rs.next()) {
                cheque = rs.getString(1);
            }
            if (cheque == null) {
                cheque = "0";

            }
            if (dd == null) {
                dd = "0";
            }


            chequenet = Double.parseDouble(cheque);
            ddnet = Double.parseDouble(dd);
            cashamt = txt_cash.getText().trim();
            if (cashamt.isEmpty()) {
                cashamt = "0";
            }
            cash = Double.parseDouble(cashamt);
            net = chequenet + ddnet + cash;
            txt_payment.setText(Double.toString(net));
            cashammount = Double.toString(net);
            //returnCash();
            //dues();


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            ex.printStackTrace();
        }

        if (txt_cash.getText().trim().length() > 0) {
            cb_cash.setSelected(true);
        } else {
            cb_cash.setSelected(false);
        }
        if (!rb_macc.isSelected()) {
            txt_total.setText(txt_payment.getText());
            txt_totalKeyReleased(null);
        }
    }
    private void db_cashWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_db_cashWindowClosing
        // TODO add your handling code here:
        cashAfterClose();
    }//GEN-LAST:event_db_cashWindowClosing

    private void cb_chequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_chequeActionPerformed
        // TODO add your handling code here:
        if (txt_chqamount.getText().trim().length() > 0) {
            cb_cheque.setSelected(true);
        } else {
            cb_cheque.setSelected(false);
        }
        db_Chq.setBounds(100, 300, 700, 230);
        db_Chq.setVisible(true);
        retrievChequeCart();
    }//GEN-LAST:event_cb_chequeActionPerformed

    private void db_ChqWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_db_ChqWindowClosing
        // TODO add your handling code here:
        double net = 0, ddnet = 0, chequenet = 0, cash = 0;
        String dd = null, cheque = null, cashamt = null;
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select sum(amount) from ddcart");
            while (rs.next()) {
                dd = rs.getString(1);
            }
            rs = stmt.executeQuery("select sum(amount) from chequecart");
            while (rs.next()) {
                cheque = rs.getString(1);
            }
            if (cheque == null) {
                cheque = "0";

            }
            if (dd == null) {
                dd = "0";
            }

            chequenet = Double.parseDouble(cheque);
            ddnet = Double.parseDouble(dd);
            cashamt = txt_cash.getText().trim();
            if (cashamt.isEmpty()) {
                cashamt = "0";
            }
            cash = Double.parseDouble(cashamt);
            net = chequenet + ddnet + cash;
            txt_payment.setText(Double.toString(net));
            cashammount = Double.toString(net);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            ex.printStackTrace();
        }


        if (!cheque.equals("0")) {
            cb_cheque.setSelected(true);
        } else {
            cb_cheque.setSelected(false);
        }

        if (rb_macc.isSelected() == false) {
            txt_total.setText(txt_payment.getText());
            txt_totalKeyReleased(null);
        }

    }//GEN-LAST:event_db_ChqWindowClosing

    private void db_DDWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_db_DDWindowClosing
        // TODO add your handling code here:
        double net = 0, ddnet = 0, chequenet = 0, cash = 0;
        String dd = null, cheque = null, cashamt = null;
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select sum(amount) from ddcart");
            while (rs.next()) {
                dd = rs.getString(1);
            }
            rs.close();
            rs = stmt.executeQuery("select sum(amount) from chequecart");
            while (rs.next()) {
                cheque = rs.getString(1);
            }
            if (cheque == null) {
                cheque = "0";

            }
            if (dd == null) {
                dd = "0";

            }


            chequenet = Double.parseDouble(cheque);
            ddnet = Double.parseDouble(dd);
            cashamt = txt_cash.getText().trim();
            if (cashamt.isEmpty()) {
                cashamt = "0";
            }
            cash = Double.parseDouble(cashamt);
            net = chequenet + ddnet + cash;
            txt_payment.setText(Double.toString(net));
            cashammount = Double.toString(net);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        }

        if (!dd.equals("0")) {
            cb_dd.setSelected(true);
        } else {
            cb_dd.setSelected(false);
        }
        if (!rb_macc.isSelected()) {
            txt_total.setText(txt_payment.getText());
            txt_totalKeyReleased(null);
        }

    }//GEN-LAST:event_db_DDWindowClosing

    public void retrievChequeCart() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select chqno as 'Cheque No',date  as 'Date',bankname as 'Bank',amount as 'Amount' from chequecart");
            table_chq.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            txt_chqamount.setText("");
            txt_chqbank.setText("");
            txt_chqno.setText("");
            txt_chqno.requestFocus();
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            ex.printStackTrace();
        }
    }

    public void retrievDDCart() {
        try {
            con = Util.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select ddno as 'DD No',date  as 'Date',bankname as 'Bank',amount as 'Amount' from ddcart");
            table_dd.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));
            txt_DDAmount.setText("");
            txt_DDBank.setText("");
            txt_DDNo.setText("");
            txt_DDNo.requestFocus();
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            ex.printStackTrace();
        }
    }

    private void txt_chqamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chqamountActionPerformed
        // TODO add your handling code here:
        java.util.Date d = db_chqdate.getDate();
        java.sql.Date pdate = new java.sql.Date(d.getTime());
        String pdate1 = pdate.toString();
        if (!txt_chqamount.getText().isEmpty() && !txt_chqno.getText().isEmpty()) {
            double amount = 0;
            long c = 0;
            try {
                amount = Double.parseDouble(txt_chqamount.getText());
                c = Integer.parseInt(txt_chqno.getText());
                con = Util.getConnection();
                stmt = con.createStatement();
                stmt.executeUpdate("insert into chequecart values('rcpno','rollno','enrollno','" + txt_chqno.getText() + "','" + txt_chqbank.getText().trim() + "','" + pdate1 + "','" + amount + "')");
                retrievChequeCart();
                stmt.close();
                con.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid check no.\nError :- " + ex.toString());
                txt_chqno.requestFocus();
                ex.printStackTrace();

            }
        }
    }//GEN-LAST:event_txt_chqamountActionPerformed

    private void table_chqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_chqKeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_DELETE) {
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                stmt.executeUpdate("delete from chequecart where chqno=" + chequeno + "");
                retrievChequeCart();
                stmt.close();
                con.close();
            } catch (Exception e) {
            }
        }
        if (code == KeyEvent.VK_UP) {
            int row = table_chq.getSelectedRow();
            chequeno = table_chq.getValueAt(row - 1, 0).toString();
        }
        if (code == KeyEvent.VK_DOWN) {
            int row = table_chq.getSelectedRow();
            chequeno = table_chq.getValueAt(row + 1, 0).toString();
        }
    }//GEN-LAST:event_table_chqKeyPressed

    private void table_chqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_chqMouseClicked
        // TODO add your handling code here:
        int row = table_chq.getSelectedRow();
        chequeno = table_chq.getValueAt(row, 0).toString();
    }//GEN-LAST:event_table_chqMouseClicked

    private void txt_DDAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DDAmountActionPerformed
        // TODO add your handling code here:
        java.util.Date d = dc_dd.getDate();
        java.sql.Date pdate = new java.sql.Date(d.getTime());
        String pdate1 = pdate.toString();
        if (!txt_DDAmount.getText().isEmpty() && !txt_DDNo.getText().isEmpty()) {
            double amount = 0;
            long c = 0;
            try {
                amount = Double.parseDouble(txt_DDAmount.getText());
                c = Integer.parseInt(txt_DDNo.getText());
                con = Util.getConnection();
                stmt = con.createStatement();
                stmt.executeUpdate("insert into ddcart values('rcpno','rollno','enrollno','" + txt_DDNo.getText() + "','" + txt_DDBank.getText().trim() + "','" + pdate1 + "','" + amount + "')");
                stmt.close();
                con.close();
                retrievDDCart();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please enter valid check no");
                txt_DDNo.requestFocus();
                e.printStackTrace();

            }
        }
    }//GEN-LAST:event_txt_DDAmountActionPerformed

    private void table_ddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ddMouseClicked
        // TODO add your handling code here:
        int row = table_dd.getSelectedRow();
        ddno = table_dd.getValueAt(row, 0).toString();
    }//GEN-LAST:event_table_ddMouseClicked

    private void table_ddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_ddKeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        if (code == KeyEvent.VK_DELETE) {
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                stmt.executeUpdate("delete from ddcart where ddno=" + ddno + "");
                stmt.close();
                con.close();
                retrievDDCart();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
        if (code == KeyEvent.VK_UP) {
            int row = table_dd.getSelectedRow();
            ddno = table_dd.getValueAt(row - 1, 0).toString();
        }
        if (code == KeyEvent.VK_DOWN) {
            int row = table_dd.getSelectedRow();
            ddno = table_dd.getValueAt(row + 1, 0).toString();
        }
    }//GEN-LAST:event_table_ddKeyPressed

    private void txt_paymentPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_paymentPropertyChange
        // TODO add your handling code here:
        txt_total.setText(txt_payment.getText());
    }//GEN-LAST:event_txt_paymentPropertyChange

    private void txt_paymentVetoableChange(java.beans.PropertyChangeEvent evt) throws java.beans.PropertyVetoException {//GEN-FIRST:event_txt_paymentVetoableChange
        // TODO add your handling code here:
        txt_total.setText(txt_payment.getText());
    }//GEN-LAST:event_txt_paymentVetoableChange

    private void txt_tfeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tfeeKeyReleased
        // TODO add your handling code here:
        accountsum();
    }//GEN-LAST:event_txt_tfeeKeyReleased

    private void txt_hostelfeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hostelfeeKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_hostelfeeKeyReleased

    private void txt_messfeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_messfeeKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_messfeeKeyReleased

    private void txt_examfeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_examfeeKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_examfeeKeyReleased

    private void txt_uniformchargeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uniformchargeKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_uniformchargeKeyReleased

    private void txt_busfareKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busfareKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_busfareKeyReleased

    private void txt_otherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_otherKeyReleased
        // TODO add your handling code here:
        accountsum();
        txt_total.setText(Double.toString(acctotal));
    }//GEN-LAST:event_txt_otherKeyReleased

    private void txt_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cashActionPerformed
        // TODO add your handling code here:
        db_cash.hide();
        cashAfterClose();
    }//GEN-LAST:event_txt_cashActionPerformed

    private void txt_erollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_erollActionPerformed
        // TODO add your handling code here:
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("select roll_number, first_name, middle_name, last_name, course, branch, semester  from student_details where enrollment_number = '" + txt_eroll.getText().trim() + "'");
            ResultSet rs1 = pstmt.executeQuery();
            if (rs1.next()) {
                txt_rollno.setText(rs1.getString(1));
                txt_fname.setText(rs1.getString(2));
                txt_mname.setText(rs1.getString(3));
                txt_lname.setText(rs1.getString(4));
                cmb_course.setSelectedItem(rs1.getString(5));
                txt_sem.setSelectedItem(rs1.getString(6));
            } else {
                JOptionPane.showMessageDialog(this, "Enrollment number doesnot exist.");
                txt_rollno.setText("");
                txt_fname.setText("");
                txt_mname.setText("");
                txt_lname.setText("");
                cmb_course.setSelectedIndex(0);
                txt_sem.setSelectedIndex(0);
                txt_due.setText("");
            }
            rs1.close();
            pstmt.close();

            pstmt = con.prepareStatement("select padd, pcity, pstate, pcountry, ppin  from student_address where enrollmentno = '" + txt_eroll.getText().trim() + "'");
            ResultSet rs2 = pstmt.executeQuery();
            if (rs2.next()) {
                txt_add.setText(rs2.getString(1).trim() + ", " + rs2.getString(2).trim() + ", " + rs2.getString(3).trim() + ", " + rs2.getString(4).trim() + " ( " + rs2.getString(5).trim() + ")");
            } else {
                txt_add.setText("");
            }
            rbDue.setSelected(true);

            rs2.close();
            pstmt.close();
            con.close();
            totaldueEnroll();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        } catch (NullPointerException ex) {
        }

    }//GEN-LAST:event_txt_erollActionPerformed

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:    
        try {
            con = Util.getConnection();
            pstmt = con.prepareStatement("select enrollment_number, first_name, middle_name, last_name, course, semester, session  from student_details where roll_number = '" + txt_rollno.getText().trim() + "'");
            ResultSet rs1 = pstmt.executeQuery();
            if (rs1.next()) {
                txt_eroll.setText(rs1.getString(1));
                txt_fname.setText(rs1.getString(2));
                txt_mname.setText(rs1.getString(3));
                txt_lname.setText(rs1.getString(4));
                cmb_course.setSelectedItem(rs1.getString(5));
                txt_sem.setSelectedItem(rs1.getString(6));
                System.out.println("year from " + rs1.getString(7).substring(0, 4));
                year_from.setYear(Integer.parseInt(rs1.getString(7).substring(0, 4)));
                year_to.setYear(Integer.parseInt(rs1.getString(7).substring(5)));
            } else {
                JOptionPane.showMessageDialog(this, "Roll no. doesnot exist.");
                txt_eroll.setText("");
                txt_fname.setText("");
                txt_mname.setText("");
                txt_lname.setText("");
                cmb_course.setSelectedIndex(0);
                txt_sem.setSelectedIndex(0);
                txt_due.setText("");
            }
            rs1.close();
            pstmt.close();

            pstmt = con.prepareStatement("select padd, pcity, pstate, pcountry, ppin  from student_address where roll_number = '" + txt_rollno.getText().trim() + "'");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                txt_add.setText(rs.getString(1).trim() + ", " + rs.getString(2).trim() + ", " + rs.getString(3).trim() + ", " + rs.getString(4).trim() + " ( " + rs.getString(5).trim() + ")");
            } else {
                txt_add.setText("");
            }
            rs.close();
            pstmt.close();

            rbDue.setSelected(true);
            totaldue();
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
        } catch (NullPointerException ex) {
        }


    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void txt_dueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_dueMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dueMouseEntered

    public void totaldueEnroll() {
        if (rb_select.isSelected() == false) {
            double fdtotal = 0, prtotal = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select total  from fee_details where enrollmentno = '" + txt_eroll.getText() + "'");
                if (rs_fd.next()) {
                    fdtotal = Double.parseDouble(rs_fd.getString(1));
                }

                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(amount) from pay_report where enrollmentno = '" + txt_eroll.getText() + "'");
                if (rs_pr.next()) {
                    prtotal = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;
                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtotal - prtotal;
                wholedue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }

    public void totaldue() {
        if (rb_select.isSelected() == false) {
            double fdtotal = 0, prtotal = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select total  from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtotal = Double.parseDouble(rs_fd.getString(1));

                }
                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(amount) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtotal = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtotal - prtotal;
                wholedue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }

    public void tdue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;

            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  ttf from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(tutionfee) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtution - prtution;
                tutiondue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }

    }
    private void txt_tfeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tfeeFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            tdue();
        }
    }//GEN-LAST:event_txt_tfeeFocusGained

    public void hdue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  thf from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(hostelfee) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtution - prtution;
                hosteldue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }
    private void txt_hostelfeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_hostelfeeFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            hdue();
        }

    }//GEN-LAST:event_txt_hostelfeeFocusGained

    public void mdue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  tmf from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(messfee) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtution - prtution;
                messdue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }
    private void txt_messfeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_messfeeFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            mdue();
        }
    }//GEN-LAST:event_txt_messfeeFocusGained

    public void edue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  tef from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                rs_fd.close();
                ResultSet rs_pr = stmt.executeQuery("select  sum(examfee) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                rs_pr.close();
                stmt.close();
                con.close();

                double due = fdtution - prtution;
                examdue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }
    private void txt_examfeeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_examfeeFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            edue();
        }
    }//GEN-LAST:event_txt_examfeeFocusGained

    public void udue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  tuf from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                ResultSet rs_pr = stmt.executeQuery("select  sum(uniformcharge) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                double due = fdtution - prtution;
                uniformdue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }
    private void txt_uniformchargeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_uniformchargeFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            udue();
        }
    }//GEN-LAST:event_txt_uniformchargeFocusGained

    public void bdue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  tbf from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                ResultSet rs_pr = stmt.executeQuery("select  sum(busfare) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                double due = fdtution - prtution;
                busdue = due;
                txt_due.setText(String.valueOf(due));

            } catch (SQLException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error :- " + ex.toString());
            }
        }
    }
    private void txt_busfareFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_busfareFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            bdue();
        }
    }//GEN-LAST:event_txt_busfareFocusGained

    public void odue() {
        if (rb_select.isSelected() == false) {
            double fdtution = 0, prtution = 0;
            try {
                con = Util.getConnection();
                stmt = con.createStatement();
                ResultSet rs_fd = stmt.executeQuery("select  tof from fee_details where roll_number = '" + txt_rollno.getText() + "'");
                if (rs_fd.next()) {
                    fdtution = Double.parseDouble(rs_fd.getString(1));

                }
                ResultSet rs_pr = stmt.executeQuery("select  sum(other) from pay_report where rollno = '" + txt_rollno.getText() + "'");
                if (rs_pr.next()) {
                    prtution = (rs_pr.getString(1) != null) ? Double.parseDouble(rs_pr.getString(1)) : 0;

                }
                double due = fdtution - prtution;
                otherdue = due;
                txt_due.setText(String.valueOf(due));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void txt_otherFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_otherFocusGained
        // TODO add your handling code here:
        if (rbDue.isSelected() == false) {
            odue();
        }
    }//GEN-LAST:event_txt_otherFocusGained

    private void txt_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_accActionPerformed
        // TODO add your handling code here:
        int attrib = txt_acc.getSelectedIndex();
        if (rbDue.isSelected() == false) {
            if (attrib == 0) {
                tdue();
            } else if (attrib == 1) {
                hdue();
            } else if (attrib == 2) {
                mdue();
            } else if (attrib == 3) {
                edue();
            } else if (attrib == 4) {
                udue();
            } else if (attrib == 5) {
                bdue();
            } else if (attrib == 6) {
                odue();
            }
        }
    }//GEN-LAST:event_txt_accActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        try {
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_formWindowClosed

    private void rbDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDueActionPerformed
        // TODO add your handling code here:
        if (rbDue.isSelected()) {
            totaldue();
        } else if (rb_macc.isSelected() == false) {
            txt_accActionPerformed(evt);
        }

    }//GEN-LAST:event_rbDueActionPerformed

    private void lbl_rcpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_rcpnoActionPerformed
        // TODO add your handling code here:
        retrieveCheque();
        retrieveDD();
        retrievePayreport();
        cb_cashActionPerformed(evt);
        cb_chequeActionPerformed(evt);
        cb_ddActionPerformed(evt);

    }//GEN-LAST:event_lbl_rcpnoActionPerformed

    private void rb_rcpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_rcpActionPerformed
        // TODO add your handling code here:
        if (rb_rcp.isSelected()) {
            lbl_rcpno.setEditable(true);
            lbl_rcpno.setText("");
            rb_select.setSelected(false);
            rb_select.setEnabled(false);
            rb_selectActionPerformed(evt);
        } else {
            lbl_rcpno.setEditable(false);
            lbl_rcpno.setText("");
            rb_select.setEnabled(true);
            cb_cash.setSelected(false);
            cb_cheque.setSelected(false);
            cb_dd.setSelected(false);
            retrieve_rcpno();
            setblank();
            try {
                con = Util.getConnection();
                pstmt = con.prepareStatement("truncate table chequecart");
                pstmt.executeUpdate();
                pstmt = con.prepareStatement("truncate table ddcart");
                pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }//GEN-LAST:event_rb_rcpActionPerformed

    private void cmb_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_courseActionPerformed
        // TODO add your handling code here:
        retrieve_rollno();
    }//GEN-LAST:event_cmb_courseActionPerformed

    private void year_fromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_year_fromPropertyChange
        // TODO add your handling code here:
        retrieve_rollno();
    }//GEN-LAST:event_year_fromPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddmissionReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddmissionReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddmissionReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddmissionReciept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddmissionReciept().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Set;
    private javax.swing.JDialog Dialog_DateFormat;
    private javax.swing.JCheckBox cb_cash;
    private javax.swing.JCheckBox cb_cheque;
    private javax.swing.JCheckBox cb_dd;
    private javax.swing.JComboBox cmb_course;
    private javax.swing.JComboBox combo_dateformat;
    private javax.swing.JDialog db_Chq;
    private javax.swing.JDialog db_DD;
    private javax.swing.JDialog db_cash;
    private com.toedter.calendar.JDateChooser db_chqdate;
    private com.toedter.calendar.JDateChooser dc_dd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenu_Date;
    private javax.swing.JMenu jMenu_time;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_acc;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_eroll;
    private javax.swing.JLabel lbl_eroll1;
    private javax.swing.JLabel lbl_fname;
    private javax.swing.JLabel lbl_icon;
    private javax.swing.JLabel lbl_mode;
    private javax.swing.JLabel lbl_payment;
    private javax.swing.JTextField lbl_rcpno;
    private javax.swing.JLabel lbl_rupee;
    private javax.swing.JLabel lbl_rupee1;
    private javax.swing.JLabel lbl_select;
    private javax.swing.JLabel lbl_sem;
    private javax.swing.JLabel lbl_word;
    private javax.swing.JPanel panel_acc;
    private javax.swing.JRadioButton rbDue;
    private javax.swing.JRadioButton rb_macc;
    private javax.swing.JRadioButton rb_rcp;
    private javax.swing.JRadioButton rb_select;
    private javax.swing.JTable table_chq;
    private javax.swing.JTable table_dd;
    private javax.swing.JTextField txt_DDAmount;
    private javax.swing.JTextField txt_DDBank;
    private javax.swing.JTextField txt_DDNo;
    private javax.swing.JComboBox txt_acc;
    private javax.swing.JTextField txt_add;
    private javax.swing.JTextField txt_busfare;
    private javax.swing.JTextField txt_cash;
    private javax.swing.JTextField txt_chqamount;
    private javax.swing.JTextField txt_chqbank;
    private javax.swing.JTextField txt_chqno;
    private javax.swing.JTextField txt_dateformat;
    private javax.swing.JTextField txt_due;
    private javax.swing.JTextField txt_eroll;
    private javax.swing.JTextField txt_examfee;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_hostelfee;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_messfee;
    private javax.swing.JTextField txt_mname;
    private javax.swing.JTextField txt_other;
    private javax.swing.JTextField txt_payment;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JComboBox txt_sem;
    private javax.swing.JTextField txt_tfee;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_uniformcharge;
    private com.toedter.calendar.JYearChooser year_from;
    private com.toedter.calendar.JYearChooser year_to;
   
}
